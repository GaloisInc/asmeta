/*
 * generated by Xtext 2.11.0
 */
package org.asmeta.xt.generator

//import org.eclipse.core.resources.*

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class AsmetaxtextGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		fsa.generateFile('greetings.txt', 'People to greet: ' + 
//			resource.allContents
//				.filter(Greeting)
//				.map[name]
//				.join(', '))
	/*
		var asm = resource.allContents.filter(Asm).toIterable
		var destination_asm = AsmConverter.convert( asm.get(0) )
		
		print("*************************");
		print( destination_asm.main.name )
		print("*************************");
		*/
		
		/* Per accedere ai file
		 
		var libraryFile = ""
        
        val theRelativeFile = resource.URI.trimFileExtension.appendFileExtension('gen')
        
		if (resource.URI.isPlatform) 
			libraryFile = ResourcesPlugin.workspace.root.getFile(new Path(theRelativeFile.toPlatformString(true))).rawLocation.toOSString	     	
		else 
			libraryFile = resource.resourceSet.URIConverter.normalize(theRelativeFile).toFileString
		*/
		
	}
	
	
}
