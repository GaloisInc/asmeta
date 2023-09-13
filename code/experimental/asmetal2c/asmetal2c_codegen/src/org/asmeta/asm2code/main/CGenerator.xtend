package org.asmeta.asm2code.main;

import asmeta.definitions.ControlledFunction
import asmeta.definitions.RuleDeclaration
import asmeta.definitions.StaticFunction
import asmeta.definitions.domains.AbstractTd
import asmeta.definitions.domains.EnumTd
import asmeta.structure.Asm
import asmeta.transitionrules.basictransitionrules.Rule
import org.asmeta.asm2code.DomainToH
import org.asmeta.asm2code.FindMonitoredInControlledFunct
import org.asmeta.asm2code.Util
import java.util.List
import java.util.ArrayList
import org.asmeta.asm2code.SeqRuleCollector
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.asmeta.asm2code.main.TranslatorOptions.CompilerType
import asmeta.terms.basicterms.SetTerm
import asmeta.definitions.domains.IntegerDomain
import asmeta.AsmCollection
import org.asmeta.asm2code.formatter.Formatter
import java.nio.file.Files
import java.nio.file.Paths
import org.asmeta.asm2code.FunctionToC
import org.asmeta.asm2code.RuleToC
import org.asmeta.asm2code.DomainToC

/**Generates .c ASM file */
class CGenerator extends AsmToCGenerator {
	public static String Ext = ".c"
	String initConrolledMonitored

	new () {
		super()
	}

	new (TranslatorOptions options) {
		super(options)
	}
	
	// all the rules that must translate in two versions seq and not seq
	// if null, translate all
	List<Rule> seqCalledRules;
	
	def generate(AsmCollection model, String path) {
		if (options === null) throw new Exception("TranslationOptions not initialized")
		var compiled = compileAsm(model)
		if (options.formatter)
			compiled = Formatter.formatCode(compiled)
		Files.write(Paths.get(path), compiled.getBytes())
	}
	
	def compileAsm(AsmCollection asmCol){
		var Asm asm = asmCol.main
		if (options.optimizeSeqMacroRule) {
			seqCalledRules = new ArrayList
			for (r : asm.bodySection.ruleDeclaration)
				seqCalledRules.addAll(new SeqRuleCollector(false).visit(r))
		}
		//
		val asmName = asm.name
		functionSignature(asm)
		// TODO fix include list
		return '''
				/* «asmName».«Ext» automatically generated from ASM2CODE */
				#include "«asmName».h"
				
				/* init static functions and elements of abstract domains */
				«initStatic(asm)»
				
				/* Static function definition */
				«functionDefinition(asm)»
				«IF(options.compilerType == CompilerType.ArduinoCompiler)»
				«/*possibleValueOfStaticDomain(asm)*/»
				
				/* Function and domain initialization */
				void init() {
				«initialDynamicDomainDefinition(asm)»
				«ELSE»
				/* Function and domain initialization */
				void init(){
				«initialDynamicDomainDefinition(asm)»
				«ENDIF»
				/* Init static functions Abstract domain */
				«functionAbstractDom(asm)»
				/* Function initialization */
				«functionInitialization(asm)»
				}
			
				/* Apply the update set */
				void step(){
					«updateSet(asmCol)»
				}

				/* Conversion of ASM rules in C functions */
				«ruleDefinitions(asm)»
		'''
		
	}

	override compileAsm(Asm asm) {
		if (options.optimizeSeqMacroRule) {
			seqCalledRules = new ArrayList
			for (r : asm.bodySection.ruleDeclaration)
				seqCalledRules.addAll(new SeqRuleCollector(false).visit(r))
		}
		//
		val asmName = asm.name
		functionSignature(asm)
		// TODO fix include list
		return '''
				/* «asmName».c automatically generated from ASM2CODE */
				#include "«asmName».h"
				
				/* init static functions and elements of abstract domains */
				«initStatic(asm)»
				
				/* Static function definition */
				«functionDefinition(asm)»
				«IF(options.compilerType == CompilerType.ArduinoCompiler)»
				«/*possibleValueOfStaticDomain(asm)*/»
				
				/* Function and domain initialization */
				void init()«/*initialStaticDomainDefinition(asm)*/»«/*initialStaticDomain(asm)*/»{
				«initialStaticDomainArduino(asm)» //MOD
				«initialDynamicDomainDefinition(asm)»
				«ELSE»
				/* Function and domain initialization */
				void init()«/*initialStaticDomain(asm)*/»{
				«initialDynamicDomainDefinition(asm)»
				«ENDIF»
				/* Init static functions Abstract domain */
				«functionAbstractDom(asm)»
				/* Function initialization */
				«functionInitialization(asm)»
				}
			
				/* Apply the update set */
				void step(){
					«updateSet(asm)»
				}
				
				/* Conversion of ASM rules in C methods */
				«ruleDefinitions(asm)»
				
		'''

	}
	
	
	
	def initStatic(Asm asm) {
		return '''struct «asm.name» _«asm.name»;'''
//		var sb = new StringBuffer;
//		for (dd : asm.headerSection.signature.domain) {
//			if (dd instanceof AbstractTd) {
//				var domain = new DomainToH(asm).visit(dd)
//				sb.append(options.stdNamespacePrefix + "set< " + domain + "*>" + domain + "::elems;\n")
//			}
//		}
//		for (fd : asm.headerSection.signature.function) {
//			if (fd instanceof StaticFunction && fd.codomain instanceof AbstractTd)
//				sb.append(new DomainToH(asm).visit(fd.codomain) + "*" + asm.name + "::" + fd.name + ";\n")
//		}
//		return sb.toString
	}

	def functionAbstractDom(Asm asm) {
		var sb = new StringBuffer;
		for (fd : asm.headerSection.signature.function) {
			if (fd instanceof StaticFunction && fd.codomain instanceof AbstractTd)
				sb.append(fd.name + " = new " + new DomainToH(asm).visit(fd.codomain) + ";\n")
		}
		return sb.toString
	}

	def functionSignature(Asm asm) {
		/*for (fd : asm.headerSection.signature.function) {
		 * 	if (fd instanceof MonitoredFunction)
		 * 		monitoredMap.add(fd.name)
		 }*/
	}

	/** TODO
	 * funzioni statiche implementazione
	 * regole implementazione
	 * term implementazione
	 */
	def updateSet(Asm asm) {
		var StringBuffer updateset = new StringBuffer/*
		for (imp : asm.headerSection.importClause){ //Inizializzazione
			if(!imp.moduleName.contains("StandardLibrary")){
				var String[] buffer = imp.moduleName.split("/")
				var String name = buffer.get(buffer.length - 1)
				updateset.append('''«name» «name.toLowerCase»;''')
			}
	
		} */
		for (cf : asm.headerSection.signature.function)
			if (cf instanceof ControlledFunction)
				updateset.append('''«cf.name»[0] = «cf.name»[1];
				''')
		if(asm.name.contains("main"))
		for (imp : asm.headerSection.importClause){ //Chiamata al metodo fireUpdateSet();
			//println("IMPORT CLAUSE " + imp.moduleName.toString)
			if(!imp.moduleName.contains("StandardLibrary")){
				var String[] buffer = imp.moduleName.split("/")
				updateset.append('''step();''')
			}
		}
		return updateset.toString
	}
	
	def updateSet(AsmCollection asmCol){
		val asm = asmCol.main
		// check if the main asm has a main rule
		if(asm.mainrule !== null) {
			return asmCol.filter [ x | !x.name.contains("StandardLibrary") ]
			      	     .flatMap [ asm1 | asm1.headerSection.signature.function.filter(ControlledFunction) ]
			      		 .map [ cf | '''_«asm.name».out.«cf.name»[0] = _«asm.name».out.«cf.name»[1];''' ]
						 .join("\n")
		} else {
			return ""
		}
	}

 
	def initialStaticDomainDefinition(Asm asm) {
		var StringBuffer initial = new StringBuffer
		if (asm.bodySection !== null && asm.bodySection.domainDefinition !== null) {
			for (dd : asm.bodySection.domainDefinition) {
				var String n = dd.definedDomain.name
				initial.append((Util.getElemsSetName(dd.definedDomain.name) + ("(" +
					(new DomainToC(asm).visit(dd)).replace("{", if (options.compilerType==CompilerType.ArduinoCompiler) 
						"{&var" + n + "_" else "{var" + n + "_").replace(",",if (options.compilerType==CompilerType.ArduinoCompiler) ",&var" + n + "_" else ",var" + n + "_") + "),").replaceAll("\\s+","") + "\n"
				))
			}
		}
		if (asm.headerSection !== null && asm.headerSection.signature !== null &&
			asm.headerSection.signature.domain !== null) {
			for (ed : asm.headerSection.signature.domain.filter(EnumTd)) {
				var String n = ed.name;
				initial.append(Util.getElemsSetName(ed.name) + "(" + (new DomainToC(asm).visit(ed)).replace(
					"{", if (options.compilerType==CompilerType.ArduinoCompiler) "{&var" + n + "_" else "{var_").replace(",", 
						if (options.compilerType==CompilerType.ArduinoCompiler) ",&var_" + n + "_" else ",var_"
					) + "
				), \n")
			}
		}
		if (initial.toString.length != 0)
			return ": \n" + "// Static domain initialization \n" +
				initial.toString.substring(0, initial.toString.length - 3) + "\n"
		else
			return ""
	}
	
	def initialStaticDomainArduino(Asm asm){
		var StringBuffer initial = new StringBuffer
		if(asm.bodySection !== null && asm.bodySection.domainDefinition !== null){
			for (dd : asm.bodySection.domainDefinition) {
				if(dd.body instanceof SetTerm && dd.body.domain.name.contains("Integer")){
					var SetTerm s = dd.body as SetTerm;
					var String domain = s.domain.name
					println("is set term." + " Domain " + domain)
					initial.append(Util.getElemsSetName(dd.definedDomain.name) + ":" + (new DomainToC(asm).visitArduino(s)  + "; \n"  ))
				}
				else
				initial.append(Util.getElemsSetName(dd.definedDomain.name) + ":" + (new DomainToC(asm).visit(dd)  + "; \n"  ))
			} 
		}
		if(asm.headerSection !== null && asm.headerSection.signature !== null && asm.headerSection.signature.domain !== null){
			for(ed : asm.headerSection.signature.domain) {
				if(ed instanceof EnumTd) {
					initial.append("\n" + Util.getElemsSetName(ed.name) + ":" + (new DomainToC(asm).visit(ed,true)) + " \n")
				}
			}
		}
		if (initial.toString.length != 0)
		return "//Static domain initialization \n" +
			initial.toString.substring(0, initial.toString.length - 2) + "\n"
		else return ""
	}
	
//	def initialStaticDomain(Asm asm){
//		var StringBuffer initial = new StringBuffer
//		if(asm.bodySection !== null && asm.bodySection.domainDefinition !== null){
//			for (dd : asm.bodySection.domainDefinition) {
//				initial.append(Util.getElemsSetName(dd.definedDomain.name) + "(" + (new DomainToCpp(asm).visit(dd)) + "), \n"  )
//			} 
//		}
//		if(asm.headerSection !== null && asm.headerSection.signature !== null && asm.headerSection.signature.domain !== null){
//			for(ed : asm.headerSection.signature.domain) {
//				if(ed instanceof EnumTd) {
//					initial.append(Util.getElemsSetName(ed.name) + "(" + (new DomainToCpp(asm).visit(ed)) + "), \n")
//				}
//			}
//		}
//		if (initial.toString.length != 0)
//		return ": \n" + "//Static domain initialization \n" +
//			initial.toString.substring(0, initial.toString.length - 3) + "\n"
//		else return ""
//	}
	

	def initialDynamicDomainDefinition(Asm asm) {
		var StringBuffer initial = new StringBuffer
		if (asm.defaultInitialState !== null && asm.defaultInitialState.domainInitialization !== null) {
			for (dd : asm.defaultInitialState.domainInitialization) {
				val domaintoc = new DomainToC(asm).visit(dd)
				initial.append(Util.getElemsSetName(dd.initializedDomain.name) + "=" + domaintoc + ";\n")
			}
		}
		if (initial.length != 0)
			return "// Dynamic domain initialization \n" + initial.toString
		else
			return ""
	}

	def initControlled(Asm asm) {
		//var boolean containsMonitored = false
		if (asm.defaultInitialState !== null && asm.defaultInitialState.functionInitialization !== null) {
			for (fd : asm.defaultInitialState.functionInitialization) {
				// println("Function defined " + fd.initializedFunction.name)
			}
		}
	}

	def functionInitialization(Asm asm) {
		var StringBuffer initial = new StringBuffer

		var StringBuffer initialMonitored = new StringBuffer
		var boolean containsMonitored = false
		if (asm.defaultInitialState !== null && asm.defaultInitialState.functionInitialization !== null) {
			for (fd : asm.defaultInitialState.functionInitialization) {
				// println("Function defined " + fd.initializedFunction.name)
				// containsMonitored=new FindMonitoredInControlledFunct(asm,mo).visit(fd.initializedFunction.initialization.get(0).body);
				containsMonitored = new FindMonitoredInControlledFunct(asm).visit(fd.body);

				if (containsMonitored == false)
					initial.append(
		  					'''«new FunctionToC(asm, options).visit(fd.initializedFunction)»
					''')
				else
					initialMonitored.append(
		  					'''«new FunctionToC(asm, options).visit(fd.initializedFunction)»
					''')
			}
		}
		/* TODO
		 * 		for (fd : res.allContents.toIterable.filter(OutFunctionImpl))
		 * 			if (fd.initialDef !== null)
		 * 				initial.append(
		 * 				'''«fd.name» = «new Initialization(res).doSwitch((fd as OutFunctionImpl).initialDef.term)»;
		 * 				''')

		 * 		for (fd : res.allContents.toIterable.filter(SharedFunctionImpl))
		 * 			if (fd.initialDef !== null)
		 * 				throw new RuntimeException("Error: initialization of a shared function not supported:")
		 */
		initConrolledMonitored = initialMonitored.toString.replaceAll("\\$", "_")
		return initial.toString.replaceAll("\\$", "_")
	}

	def ruleDefinitions(Asm e) {
		var StringBuffer sb = new StringBuffer
		for (r : e.bodySection.ruleDeclaration)
			sb.append(ruleImplementation(r, e).replaceAll("\\$", "_"))
		return sb.toString
	}

	def functionDefinition(Asm asm) { // Static and Derived function
		var StringBuffer sb = new StringBuffer
		if (asm.bodySection !== null && asm.bodySection.functionDefinition !== null) {
			for (fd : asm.bodySection.functionDefinition)
				sb.append(
		  					'''«new FunctionToC(asm).visit(fd.definedFunction)»
				''')
			return sb.toString.replaceAll("\\$", "_")
		}
		return ""
	}
	
	def String possibleValueOfStaticDomain(Asm asm) {
		var StringBuffer initial = new StringBuffer
		// Let's find all the Static domains initialitazion
		if (asm.bodySection !== null && asm.bodySection.domainDefinition !== null) {
			for (dd : asm.bodySection.domainDefinition) {
				initial.append(Util.getElemsSetName(dd.definedDomain.name) + "(" + new DomainToC(asm).visit(dd) +
					") \n")
			}
		}
		if (asm.headerSection !== null && asm.headerSection.signature !== null &&
			asm.headerSection.signature.domain !== null) {
			for (ed : asm.headerSection.signature.domain) {
				if (ed instanceof EnumTd) {
					initial.append(Util.getElemsSetName(ed.name) + "(" + new DomainToC(asm).visit(ed) + ") \n")
				}
			}
		}
	
		// For each static domain, collect each possibile value and create a global variable
		if (initial.toString.length != 0) {
			var String listAllDomain = initial.toString().substring(0, initial.toString().length-3).replace("_elems","")
			var listDomain = listAllDomain.split("\n")
			initial = new StringBuffer
			//var int idx = 0 //Serve per distinguere i diversi domini.
			for (String en : listDomain) {
				var indexName = en.indexOf("(")
				var String name = en.substring(0,indexName)
				var enumName = en.substring(0,en.indexOf("("))
				var index = en.indexOf("{")
				while (index < en.indexOf("}")-1) {
					var lastIndex = index + 1;
					if (en.substring(index + 1).contains(","))
						lastIndex = en.indexOf(",", index+1)
					else
						lastIndex = en.indexOf("}", index+1)
					//initial.append(enumName + " var_" + en.substring(index+1, lastIndex).trim() + " = " + en.substring(index+1, lastIndex) + ";\n")
					initial.append(enumName + " var" + name + "_" + en.substring(index+1, lastIndex).trim() + " = " + en.substring(index+1, lastIndex) + ";\n"
					)
					index = lastIndex
				}
				//idx = idx +1 //incrementa quando si inizializzano diversi domini.	
			}
			return initial.toString.substring(0, initial.toString.length)
			
		}
		else
			return ""
	}
	
	def String ruleImplementation(RuleDeclaration r, Asm asm) {
		var StringBuffer result = new StringBuffer
		// seq variant if required
		if (seqCalledRules === null || seqCalledRules.contains(r.ruleBody)) {
			result.append(foo(r, r.name + "_seq", asm))
		}
		// not seq done in any case
		result.append(foo(r, r.name, asm))
		return result.toString
	}

	def String foo(RuleDeclaration r, String methodName, Asm asm) {
		if (r.arity == 0)
			return ('''
				void «methodName»(){
					«new RuleToC(asm,false,options).visit(r.ruleBody as Rule)»
				}
			''')
		else
			return ( '''
				void «methodName» («new Util().adaptRuleParam(r.variable, asm)»){
					«new RuleToC(asm,false,options).visit(r.ruleBody)»
				}
			''')

	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
