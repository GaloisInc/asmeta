/*
 * generated by Xtext 2.24.0
 */
package org.asmeta.xt.parser.antlr;

import com.google.inject.Inject;
import org.asmeta.xt.parser.antlr.internal.InternalAsmetaLParser;
import org.asmeta.xt.services.AsmetaLGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class AsmetaLParser extends AbstractAntlrParser {

	@Inject
	private AsmetaLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalAsmetaLParser createParser(XtextTokenStream stream) {
		return new InternalAsmetaLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Asm";
	}

	public AsmetaLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AsmetaLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
