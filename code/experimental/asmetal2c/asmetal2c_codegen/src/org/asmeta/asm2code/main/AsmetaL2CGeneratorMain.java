package org.asmeta.asm2code.main;

import java.io.File;

import org.asmeta.asm2code.compiler.CompileResult;
import org.asmeta.asm2code.compiler.CppCompiler;
import org.asmeta.asm2code.main.TranslatorOptions.CompilerType;
import org.asmeta.parser.ASMParser;

import asmeta.AsmCollection;

/** the main generator that calls the hpp and cpp generator and takes care of updating them in case*/
public class AsmetaL2CGeneratorMain {

	// the generator for the header
	static private HeaderGenerator hGenerator = new HeaderGenerator();

	// the generator for the code 
	static private CGenerator cGenerator = new CGenerator();
	
	
	/**
	 * 
	 * @param asmspec
	 *            the path of the spec
	 * @param compile try to compile the sources
	 * @return true if success
	 * 
	 * @throws Exception
	 */
	static public CompileResult translate(String asmspec, TranslatorOptions userOptions, boolean compile) throws Exception {
		//
		// PARSE THE SPECIFICATION
		// parse using the asmeta parser
		TranslatorOptions opt = userOptions;
		File asmFile = new File(asmspec);
		assert asmFile.exists();
		String asmname = asmFile.getName();
		String name = asmname.substring(0, asmname.lastIndexOf("."));
	
		final AsmCollection model = ASMParser.setUpReadAsm(asmFile);
		// get directory containing the file
		String currentAsmPath; 
		File dir = asmFile.getParentFile();
		if (dir == null) {
			currentAsmPath = "";
		} else {
			assert dir!=null && dir.exists() && dir.isDirectory();
			currentAsmPath = dir.getPath() + File.separator;
		}
		//
		File cFile = new File(currentAsmPath + name + CGenerator.Ext);
		File hFile = new File(currentAsmPath + name + HeaderGenerator.Ext);
	
		// delete c if exists
		if (cFile.exists())
			cFile.delete();
		assert !cFile.exists();
	
		// delete h if exists
		if (hFile.exists())
			hFile.delete();
		assert !hFile.exists();
	
		System.out.println("\n\n===" + name + " ===================");
		// write H
		try {
			hGenerator.options = userOptions;
			hGenerator.generate(model.getMain(), hFile.getCanonicalPath());
		} catch (Exception e) {
			e.printStackTrace();
			return new CompileResult(false, e.getMessage());
		}
		// write CPP
		try {
			cGenerator.options = userOptions;
			//cppGenerator.generate(model.getMain(), cppFile.getCanonicalPath());
			cGenerator.generate(model, cFile.getCanonicalPath());
		} catch (Exception e) {
			e.printStackTrace();
			return new CompileResult(false, e.getMessage());
		}
	
		// now compile it
		System.out.println("Generated h file: " + hFile.getCanonicalPath());
		System.out.println("Generated c file: " + cFile.getCanonicalPath());
		CompileResult result =  new CompileResult(true,"");
		if(opt.compilerType != CompilerType.ArduinoCompiler && compile)//se il codice � per arduino, non compila. 
			result = CppCompiler.compile(name + CGenerator.Ext, currentAsmPath, true, false, true);
		// clean the produced files
		// delete h file
		// hFile.delete();
		// delete cpp file
		// cppFile.delete();
		return result;
	}
	
	

}
