package org.asmeta.xt.validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.asmeta.avallaxt.avallaXt.Invariant;
import org.asmeta.avallaxt.avallaXt.Set;
import org.asmeta.parser.ASMParser;
import org.asmeta.parser.Defs;
import org.asmeta.parser.util.AsmPrinter;
import org.asmeta.simulator.util.MonitoredFinder;
import org.asmeta.simulator.util.StandardLibrary;
import org.eclipse.emf.common.util.EList;

import asmeta.AsmCollection;
import asmeta.definitions.Function;
import asmeta.definitions.MonitoredFunction;
import asmeta.definitions.RuleDeclaration;
import asmeta.definitions.SharedFunction;
import asmeta.definitions.TemporalProperty;
import asmeta.definitions.domains.Domain;
import asmeta.definitions.domains.ProductDomain;
import asmeta.structure.Asm;
import asmeta.structure.FunctionInitialization;
import asmeta.structure.ImportClause;
import asmeta.structure.Initialization;
import asmeta.terms.basicterms.Term;
import asmeta.transitionrules.basictransitionrules.MacroDeclaration;
import org.asmeta.simulator.Environment;
import org.asmeta.simulator.Environment.TimeMngt;

public class AsmetaPrinterForAvalla extends AsmPrinter {

	// TODO just one should be enough
	private String tempAsmName;
	String tempAsmPath;

	// path of the parent where the original asm is stored
	Path asmPathDir;

	private AsmetaFromAvallaBuilder builder;

	private static Logger LOG = Logger.getLogger(AsmetaPrinterForAvalla.class);

	/**
	 * Instantiates a new asmeta printer for avalla.
	 *
	 * @param tempAsmPath the temp asm path where to save the new ASM (build from
	 *                    avalla)
	 * @param asmPathDir  the asm path dir whre the orginal model asm is stored
	 * @param builder     the builder
	 * @throws FileNotFoundException the file not found exception
	 */
	public AsmetaPrinterForAvalla(String tempAsmPath, Path asmPathDir, AsmetaFromAvallaBuilder builder)
			throws FileNotFoundException {
		super(tempAsmPath);
		assert tempAsmPath.endsWith(".asm");
		this.tempAsmPath = tempAsmPath;
		tempAsmName = new File(tempAsmPath).getName();
		tempAsmName = tempAsmName.substring(0, tempAsmName.length() - 4);
		this.asmPathDir = asmPathDir;
		this.builder = builder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.asmeta.parser.util.AsmPrinter#visitDefault(asmeta.structure.
	 * Initialization)
	 */
	@Override
	public void visitDefault(Initialization init) {
		if (init == null) {
			println("// added by validator");
			println("default init s0__:");
			indent();
			if (model.getMainrule() != null) {
				println("// added by validator");
				println("function step__ = 0");
			}
			unIndent();
		} else {
			super.visitDefault(init);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asmeta.parser.util.AsmPrinter#sort(java.util.Collection)
	 */
	// @Override //PA: commentato il 13 set 10 per eliminare l'errore: "The
	// method sort(Collection<RuleDeclaration>) of type AsmetaFromAvallaBuilder must
	// override or
	// implement a supertype method AsmetaFromAvallaBuilder.java
	// /validator/src/org/asmeta/validator/asm line 198 Java Problem"
	public RuleDeclaration[] sort(Collection<RuleDeclaration> ruleDcls) {
		RuleDeclaration[] tmp = TopologicalSort.sort(ruleDcls);
		return tmp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asmeta.parser.util.AsmPrinter#getAsmName()
	 */
	@Override
	public String getAsmName() {
		return tempAsmName;
	}

	/**
	 * add the path.
	 * 
	 * @param imports the imports
	 */
	@Override
	public void visit(Collection<ImportClause> imports) {
		if (imports != null) {
			for (ImportClause importClause : imports) {
				// get the name of the file to import. name is relative to the load spec
				String name = importClause.getModuleName();
				// now build the path
				Path importedAsmPath = asmPathDir.resolve(name + ".asm");
				assert Files.exists(importedAsmPath)
						: " path (imported ASM) " + importedAsmPath.toString() + " does not exist";
				if (StandardLibrary.isAStandardLibrary(name)) {
					printImport(importedAsmPath);
				} else {
					// convert the file to a new file with monitored -> controlled
					// change also the path (if in a subdir)
					try {

						AsmCollection pack = ASMParser.setUpReadAsm(importedAsmPath.toFile());
						// now visit this imported asm
						// get the path of the main
						File folder = new File(tempAsmPath).getParentFile();
						assert folder.exists() && folder.isDirectory();
						// the new path for the imported file
						String includedName = pack.getMain().getName();

						Path importednewFile;

						// Check whether the file has been already processed
						System.out.println("Looking for " + includedName);

						if (AsmetaV.getFileNames().containsKey(includedName)) {
							importednewFile = Paths.get(AsmetaV.getFileNames().get(includedName));
							assert Files.exists(importednewFile) : "File not found";
						} else {
							importednewFile = Files.createTempFile("__" + includedName, ".asm");
							AsmetaV.getFileNames().put(includedName, importednewFile.toString());

							System.out.println(importednewFile);
							// if necessary buuild the subdir
							if (!Files.exists(importednewFile.getParent().toAbsolutePath())) {
								System.out
										.println("building the subdir " + importednewFile.getParent().toAbsolutePath());
								// TODO check that it is a subdir of the main directory
								Files.createDirectory(importednewFile.getParent().toAbsolutePath());
							}
							LOG.debug("original import of " + name + " converted to " + importednewFile);
							System.out.println("original import of " + name + " converted to " + importednewFile);
							AsmetaPrinterForAvalla newprinter = new AsmetaPrinterForAvalla(importednewFile.toString(),
									importedAsmPath.getParent(), builder);
							newprinter.visit(pack.getMain());

							newprinter.tempAsmName = importednewFile.getFileName().toString();

							newprinter.close();
						}
						// add the new import
						printImport(importednewFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	// the complete path of the file to import - this file must exist (in case add
	// .asm)
	// the print will transform it to a relative path to the temporary ASM written
	// without the .asm
	private void printImport(Path importedAsm) {
		String importedName = printImport(tempAsmPath,importedAsm);
		println("import " + importedName);
	}
	
	/**
	 * Prints the import.
	 *
	 * @param tempAsmPath the temp asm path
	 * @param importedAsm the imported asm
	 * @return the string to be used to 
	 */
	static String printImport(String tempAsmPath, Path importedAsm) {		
		assert importedAsm.toFile().exists() : "imported file with path " + importedAsm + " does not exists";
		assert importedAsm.toFile().getName().endsWith(".asm");
		// convert to a relative path with the current file
		assert  new File(tempAsmPath).exists();
		Path tempAsmPathParent = new File(tempAsmPath).getParentFile().toPath();
		assert tempAsmPathParent.toFile().exists() && tempAsmPathParent.toFile().isDirectory();
		// if they share the parent use just the name of the imported Asm
		String importedName;
		if (importedAsm.getParent().equals(tempAsmPathParent)) {
			// use just the name
			importedName = importedAsm.toFile().getName();
		} else {
			// use absolute path 
			importedName =  importedAsm.toAbsolutePath().normalize().toString();
		}
		// remove extension
		importedName = importedName.substring(0, importedName.length() - 4);
/*		// check if they must be must both absolute
		if (!tempAsmPathParent.isAbsolute() || !importedAsm.isAbsolute()) {
			importedAsm = importedAsm.toAbsolutePath();
			tempAsmPathParent = tempAsmPathParent.toAbsolutePath();
		}
		// check if it can be relativized
		Path asm_to_import = null;
		try {
			asm_to_import = tempAsmPathParent.relativize(importedAsm);
//			if (!asm_to_import.toFile().exists()) {
//				asm_to_import = importedAsm.normalize();
//			}
		} catch (IllegalArgumentException ie) {
			asm_to_import = importedAsm.normalize();
		}
		// transform to string
		String importedName = asm_to_import.toString();
		// remove extension
		importedName = importedName.substring(0, importedName.length() - 4);*/
		
		// replace \ with \\ so when printed it will be printed correctly (with \\)
		// TODO the path should be OS independent
		importedName = importedName.replace("\\", "\\\\");
		// if the name contains spaces, add the double quotes
		if (importedName.contains(" ")) {
			assert !importedName.contains("\"");
			importedName = "\"" + importedName + "\"";
		}
		LOG.debug("tempAsmPath      " + tempAsmPath);
		LOG.debug("importedAsm      " + importedAsm);
		LOG.debug("importedName --> " + importedName);
		return importedName;
	}

	// PA 2017/12/29
	@Override
	protected void visitInvariantBody(asmeta.definitions.Invariant invariant) {
		MonitoredFinder mf = new MonitoredFinder();
		Term body = invariant.getBody();
		boolean isMonitoredInvariant = mf.visit(body);
		if (isMonitoredInvariant && this.builder.allMonitored.get(this.builder.allMonitored.size() - 1).isEmpty()) {
			// TODO: set the correct step number
			print("step__ >= " + (this.builder.allMonitored.size() - 1) + " or ");
		}
		super.visitInvariantBody(invariant);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.asmeta.parser.util.AsmPrinter#visitMain(asmeta.transitionrules.
	 * basictransitionrules.MacroDeclaration)
	 */
	@Override
	public void visitMain(MacroDeclaration main) {
		if (this.builder.modelInvariants != null) {
			println("//model invariants");
			super.visitInvariants(this.builder.modelInvariants);
		}
		List<Invariant> invs = this.builder.scenario.getInvariants();
		if (invs != null && invs.size() > 0) {
			println("//scenario invariants");
			for (Invariant inv : invs) {
				println("invariant inv_" + inv.getName() + " over Boolean: " + inv.getExpression());
			}
		}
		println("// new main added by validator");
		println("main rule r_main__ =");
		indent();
		println(this.builder.newMain);
	}

	@Override
	protected void visitInvariants(Collection<asmeta.definitions.Invariant> invariants) {
		// the invariants must be moved, after the old main rule
		this.builder.modelInvariants = invariants;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asmeta.parser.util.AsmPrinter#visitFunctions(java.util.Collection)
	 */
	@Override
	public void visitFunctions(Collection<Function> funcs) {
		if (model.getMainrule() != null) {
			println("// added by validator");
			println("controlled step__: Integer");
		}
		super.visitFunctions(funcs);
	}

	@Override
	public void visitDcl(Function function) {
		String name = function.getName();
		Domain domain = function.getDomain();
		Domain codomain = function.getCodomain();
		//26/04/2021 -> Silvia: do not convert monitored to controlled if simulation time is set to auto increment or use java time
		if ((Environment.timeMngt == TimeMngt.auto_increment || Environment.timeMngt == TimeMngt.use_java_time) && Environment.monTimeFunctions.containsKey(name)) {
				println("// Auto_increment time: keep function monitored");
				print("monitored ");
		} else
			visitUnknownDcl(function);
		print(name + ": ");
		if (domain != null) {
			visit(domain);
			print(" -> ");
		}
		visit(codomain);
		println();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.asmeta.parser.util.AsmPrinter#visitDcl(asmeta.definitions.
	 * MonitoredFunction)
	 */
	@Override
	public void visitDcl(MonitoredFunction function) {
		println("// converted to controlled by validator");
		print("controlled ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asmeta.parser.util.AsmPrinter#visitDcl(asmeta.definitions.
	 * SharedFunction )
	 */
	@Override
	public void visitDcl(SharedFunction function) {
		println("// converted to controlled by validator");
		print("controlled ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.asmeta.parser.util.AsmPrinter#visitFuncInits(java.util.Collection)
	 */
	@Override
	public void visitFuncInits(Collection<FunctionInitialization> funcs) {
		println("// added by validator");
		if (model.getMainrule() != null)
			println("function step__ = 0");

		// PA 2017/12/29
		// build the map for n-ary function
		// function insideCall($x in D) = at({1 -> "eee"}, $x)
		// function insideCall($x in D, $y in D2) = at({(1,2) -> "eee"}, ($x,$y))
		Map<String, Map<String, String>> monitoredInit = new HashMap<>();
		for (Set set : this.builder.monitoredInitState) {
			// take the function name
			String location = set.getLocation();
			int ido = location.indexOf('(');
			// PUT in the map???
			if (ido >= 0) {
				// a n-ray function
				String name = location.substring(0, ido);
				String args = location.substring(ido); // including the (
				Map<String, String> map = monitoredInit.get(name);
				if (map == null) {
					map = new HashMap<>();
					monitoredInit.put(name, map);
				}
				map.put(args, set.getValue());
			} else {
				println("function " + location + " = " + set.getValue());
			}
		}
		// get the functions
		EList<Function> functions = builder.asm.getHeaderSection().getSignature().getFunction();
		// get also the imported functions
		this.builder.asm.getHeaderSection().getImportClause().stream().map(x -> x.getImportedFunction())
				.forEach(functions::addAll);
		// print the map
		for (Entry<String, Map<String, String>> e : monitoredInit.entrySet()) {
			String funcName = e.getKey();
			// there exists a function with that name
			assert functions.stream().anyMatch(t -> t.getName().equals(funcName))
					: "function " + funcName + " not found";
			// get the signature
			Function func = functions.stream().filter(x -> x.getName().equals(funcName)).findFirst().get();
			// get the domains
			Domain domain = func.getDomain();
			List<String> domainNames = new ArrayList<String>();
			if (domain instanceof ProductDomain) {
				domainNames.addAll(((ProductDomain) domain).getDomains().stream().map(x -> x.getName())
						.collect(Collectors.toList()));
			} else {
				domainNames.add(domain.getName());
			}
			// now print variables
			print("function " + funcName + "(");
			String varNames = "";
			for (int i = 0; i < domainNames.size(); i++) {
				String dn = domainNames.get(i);
				String varname = (i != 0 ? "," : "") + "$x" + i;
				print(varname + " in " + dn);
				varNames += varname;
			}
			print(") = at({");
			// now the map !!!
			Map<String, String> values = e.getValue();
			boolean first = true;
			for (Entry<String, String> val : values.entrySet()) {
				if (!first) {
					print(",");
				}
				first = false;
				// something like (5,3) -> 6
				print(val.getKey() + "->" + val.getValue());
			}
			/// close the map
			// (5,5) -> 4}, ($r,$c))
			println("},(" + varNames + "))");
		}
		// add the init for the ASM
		super.visitFuncInits(funcs);
	}

	@Override
	protected void visitTemporalProperties(Collection<? extends TemporalProperty> properties) {
	}

	@Override
	public void visitRuleDefs(Collection<RuleDeclaration> defs) {
		if (defs != null) {
			RuleDeclaration[] rules = sortRuleDeclarations(defs);
			for (RuleDeclaration rule : rules) {
				Asm asm = Defs.getAsm(rule);
				if (asm == model) {
					visitDef(rule);
				}
			}
		}
	}

	@Override
	public void visitInit(FunctionInitialization init) {
		// collect all the location set by the init state
		java.util.Set<String> allLocations = this.builder.monitoredInitState.stream().map(x -> x.getLocation())
				.collect(Collectors.toSet());
		// check if this function is already defined in the initial state of the
		// scenario
		if (allLocations.contains(init.getInitializedFunction().getName()))
			return;
		super.visitInit(init);
	}
}