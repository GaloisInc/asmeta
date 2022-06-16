/*
 * generated by Xtext 2.16.0
 */
package org.asmeta.avallaxt.formatting2

import com.google.inject.Inject

import org.asmeta.avallaxt.services.AvallaGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.asmeta.avallaxt.avalla.Block
import org.asmeta.avallaxt.avalla.Command

class AvallaFormatter extends AbstractFormatter2 {
	
	@Inject extension AvallaGrammarAccess

	/*def dispatch void format(Scenario scenario, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (invariant : scenario.invariants) {
			invariant.format
		}
		for (element : scenario.elements) {
			element.format
		}
	}

	def dispatch void format(Block block, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (element : block.elements) {
			element.format
		}
	}*/
	
	// TODO: implement for 
	def dispatch void format(Block block, extension IFormattableDocument document) {	
		block.append[newLine]
		interior(
			block.regionFor.keyword(blockAccess.beginKeyword_0),
			block.regionFor.keyword(blockAccess.endKeyword_3)
		)[indent]
		// format the elements inside the block
		for (element : block.elements) {

			element.format
		}
	}


	// every command should start in a new line
	def dispatch void format(Command command, extension IFormattableDocument document) {
		command.prepend[newLine]
		//command.prepend[indent]	
	}
}
