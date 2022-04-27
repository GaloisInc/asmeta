/*
 * generated by Xtext 2.26.0
 */
grammar InternalAvalla;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.asmeta.avallaxt.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.asmeta.avallaxt.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.asmeta.avallaxt.services.AvallaGrammarAccess;

}

@parser::members {

 	private AvallaGrammarAccess grammarAccess;

    public InternalAvallaParser(TokenStream input, AvallaGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Scenario";
   	}

   	@Override
   	protected AvallaGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleScenario
entryRuleScenario returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScenarioRule()); }
	iv_ruleScenario=ruleScenario
	{ $current=$iv_ruleScenario.current; }
	EOF;

// Rule Scenario
ruleScenario returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='scenario'
		{
			newLeafNode(otherlv_0, grammarAccess.getScenarioAccess().getScenarioKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_GOOD_CHARS_NO_COLON
				{
					newLeafNode(lv_name_1_0, grammarAccess.getScenarioAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScenarioRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.asmeta.avallaxt.Avalla.GOOD_CHARS_NO_COLON");
				}
			)
		)
		otherlv_2='load'
		{
			newLeafNode(otherlv_2, grammarAccess.getScenarioAccess().getLoadKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getScenarioAccess().getSpecPathParserRuleCall_3_0());
				}
				lv_spec_3_0=rulePath
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScenarioRule());
					}
					set(
						$current,
						"spec",
						lv_spec_3_0,
						"org.asmeta.avallaxt.Avalla.Path");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getScenarioAccess().getInvariantsInvariantParserRuleCall_4_0());
				}
				lv_invariants_4_0=ruleInvariant
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScenarioRule());
					}
					add(
						$current,
						"invariants",
						lv_invariants_4_0,
						"org.asmeta.avallaxt.Avalla.Invariant");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getScenarioAccess().getElementsElementParserRuleCall_5_0());
				}
				lv_elements_5_0=ruleElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScenarioRule());
					}
					add(
						$current,
						"elements",
						lv_elements_5_0,
						"org.asmeta.avallaxt.Avalla.Element");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleInvariant
entryRuleInvariant returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInvariantRule()); }
	iv_ruleInvariant=ruleInvariant
	{ $current=$iv_ruleInvariant.current; }
	EOF;

// Rule Invariant
ruleInvariant returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='invariant'
		{
			newLeafNode(otherlv_0, grammarAccess.getInvariantAccess().getInvariantKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_GOOD_CHARS_NO_COLON
				{
					newLeafNode(lv_name_1_0, grammarAccess.getInvariantAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getInvariantRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.asmeta.avallaxt.Avalla.GOOD_CHARS_NO_COLON");
				}
			)
		)
		otherlv_2=':'
		{
			newLeafNode(otherlv_2, grammarAccess.getInvariantAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getInvariantAccess().getExpressionSentenceParserRuleCall_3_0());
				}
				lv_expression_3_0=rulesentence
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getInvariantRule());
					}
					set(
						$current,
						"expression",
						lv_expression_3_0,
						"org.asmeta.avallaxt.Avalla.sentence");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getInvariantAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleElement
entryRuleElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getElementRule()); }
	iv_ruleElement=ruleElement
	{ $current=$iv_ruleElement.current; }
	EOF;

// Rule Element
ruleElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getElementAccess().getCommandParserRuleCall_0());
		}
		this_Command_0=ruleCommand
		{
			$current = $this_Command_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getElementAccess().getBlockParserRuleCall_1());
		}
		this_Block_1=ruleBlock
		{
			$current = $this_Block_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleCommand
entryRuleCommand returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCommandRule()); }
	iv_ruleCommand=ruleCommand
	{ $current=$iv_ruleCommand.current; }
	EOF;

// Rule Command
ruleCommand returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getCommandAccess().getCheckParserRuleCall_0());
		}
		this_Check_0=ruleCheck
		{
			$current = $this_Check_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getCommandAccess().getSetParserRuleCall_1());
		}
		this_Set_1=ruleSet
		{
			$current = $this_Set_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getCommandAccess().getStepAction_2_0(),
						$current);
				}
			)
			{
				newCompositeNode(grammarAccess.getCommandAccess().getStepParserRuleCall_2_1());
			}
			ruleStep
			{
				afterParserOrEnumRuleCall();
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getCommandAccess().getStepUntilParserRuleCall_3());
		}
		this_StepUntil_4=ruleStepUntil
		{
			$current = $this_StepUntil_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getCommandAccess().getExecParserRuleCall_4());
		}
		this_Exec_5=ruleExec
		{
			$current = $this_Exec_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getCommandAccess().getExecBlockParserRuleCall_5());
		}
		this_ExecBlock_6=ruleExecBlock
		{
			$current = $this_ExecBlock_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleCheck
entryRuleCheck returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCheckRule()); }
	iv_ruleCheck=ruleCheck
	{ $current=$iv_ruleCheck.current; }
	EOF;

// Rule Check
ruleCheck returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='check'
		{
			newLeafNode(otherlv_0, grammarAccess.getCheckAccess().getCheckKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCheckAccess().getExpressionSentenceParserRuleCall_1_0());
				}
				lv_expression_1_0=rulesentence
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCheckRule());
					}
					set(
						$current,
						"expression",
						lv_expression_1_0,
						"org.asmeta.avallaxt.Avalla.sentence");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=';'
		{
			newLeafNode(otherlv_2, grammarAccess.getCheckAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleSet
entryRuleSet returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSetRule()); }
	iv_ruleSet=ruleSet
	{ $current=$iv_ruleSet.current; }
	EOF;

// Rule Set
ruleSet returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='set'
		{
			newLeafNode(otherlv_0, grammarAccess.getSetAccess().getSetKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSetAccess().getLocationSentenceParserRuleCall_1_0());
				}
				lv_location_1_0=rulesentence
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSetRule());
					}
					set(
						$current,
						"location",
						lv_location_1_0,
						"org.asmeta.avallaxt.Avalla.sentence");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=':='
		{
			newLeafNode(otherlv_2, grammarAccess.getSetAccess().getColonEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSetAccess().getValueSentenceParserRuleCall_3_0());
				}
				lv_value_3_0=rulesentence
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSetRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"org.asmeta.avallaxt.Avalla.sentence");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getSetAccess().getSemicolonKeyword_4());
		}
	)
;

// Entry rule entryRuleStep
entryRuleStep returns [String current=null]:
	{ newCompositeNode(grammarAccess.getStepRule()); }
	iv_ruleStep=ruleStep
	{ $current=$iv_ruleStep.current.getText(); }
	EOF;

// Rule Step
ruleStep returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw='step'
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getStepAccess().getStepKeyword());
	}
;

// Entry rule entryRuleStepUntil
entryRuleStepUntil returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStepUntilRule()); }
	iv_ruleStepUntil=ruleStepUntil
	{ $current=$iv_ruleStepUntil.current; }
	EOF;

// Rule StepUntil
ruleStepUntil returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='step'
		{
			newLeafNode(otherlv_0, grammarAccess.getStepUntilAccess().getStepKeyword_0());
		}
		otherlv_1='until'
		{
			newLeafNode(otherlv_1, grammarAccess.getStepUntilAccess().getUntilKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getStepUntilAccess().getExpressionSentenceParserRuleCall_2_0());
				}
				lv_expression_2_0=rulesentence
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getStepUntilRule());
					}
					set(
						$current,
						"expression",
						lv_expression_2_0,
						"org.asmeta.avallaxt.Avalla.sentence");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=';'
		{
			newLeafNode(otherlv_3, grammarAccess.getStepUntilAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleExec
entryRuleExec returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExecRule()); }
	iv_ruleExec=ruleExec
	{ $current=$iv_ruleExec.current; }
	EOF;

// Rule Exec
ruleExec returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='exec'
		{
			newLeafNode(otherlv_0, grammarAccess.getExecAccess().getExecKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getExecAccess().getRuleSentencePlusAssignParserRuleCall_1_0());
				}
				lv_rule_1_0=rulesentencePlusAssign
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getExecRule());
					}
					set(
						$current,
						"rule",
						lv_rule_1_0,
						"org.asmeta.avallaxt.Avalla.sentencePlusAssign");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=';'
		{
			newLeafNode(otherlv_2, grammarAccess.getExecAccess().getSemicolonKeyword_2());
		}
	)
;

// Entry rule entryRuleBlock
entryRuleBlock returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBlockRule()); }
	iv_ruleBlock=ruleBlock
	{ $current=$iv_ruleBlock.current; }
	EOF;

// Rule Block
ruleBlock returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='begin'
		{
			newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getBeginKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_GOOD_CHARS_NO_COLON
				{
					newLeafNode(lv_name_1_0, grammarAccess.getBlockAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBlockRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.asmeta.avallaxt.Avalla.GOOD_CHARS_NO_COLON");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBlockAccess().getElementsElementParserRuleCall_2_0());
				}
				lv_elements_2_0=ruleElement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBlockRule());
					}
					add(
						$current,
						"elements",
						lv_elements_2_0,
						"org.asmeta.avallaxt.Avalla.Element");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_3='end'
		{
			newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getEndKeyword_3());
		}
	)
;

// Entry rule entryRuleExecBlock
entryRuleExecBlock returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExecBlockRule()); }
	iv_ruleExecBlock=ruleExecBlock
	{ $current=$iv_ruleExecBlock.current; }
	EOF;

// Rule ExecBlock
ruleExecBlock returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='execblock'
		{
			newLeafNode(otherlv_0, grammarAccess.getExecBlockAccess().getExecblockKeyword_0());
		}
		(
			(
				(
					lv_scenario_1_0=RULE_GOOD_CHARS_NO_COLON
					{
						newLeafNode(lv_scenario_1_0, grammarAccess.getExecBlockAccess().getScenarioGOOD_CHARS_NO_COLONTerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getExecBlockRule());
						}
						setWithLastConsumed(
							$current,
							"scenario",
							lv_scenario_1_0,
							"org.asmeta.avallaxt.Avalla.GOOD_CHARS_NO_COLON");
					}
				)
			)
			otherlv_2=':'
			{
				newLeafNode(otherlv_2, grammarAccess.getExecBlockAccess().getColonKeyword_1_1());
			}
		)?
		(
			(
				lv_block_3_0=RULE_GOOD_CHARS_NO_COLON
				{
					newLeafNode(lv_block_3_0, grammarAccess.getExecBlockAccess().getBlockGOOD_CHARS_NO_COLONTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getExecBlockRule());
					}
					setWithLastConsumed(
						$current,
						"block",
						lv_block_3_0,
						"org.asmeta.avallaxt.Avalla.GOOD_CHARS_NO_COLON");
				}
			)
		)
		otherlv_4=';'
		{
			newLeafNode(otherlv_4, grammarAccess.getExecBlockAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRulePath
entryRulePath returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPathRule()); }
	iv_rulePath=rulePath
	{ $current=$iv_rulePath.current.getText(); }
	EOF;

// Rule Path
rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			this_GOOD_CHARS_NO_COLON_0=RULE_GOOD_CHARS_NO_COLON
			{
				$current.merge(this_GOOD_CHARS_NO_COLON_0);
			}
			{
				newLeafNode(this_GOOD_CHARS_NO_COLON_0, grammarAccess.getPathAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0_0());
			}
			    |
			kw=':'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getPathAccess().getColonKeyword_0_1());
			}
		)+
		    |
		this_STRING_2=RULE_STRING
		{
			$current.merge(this_STRING_2);
		}
		{
			newLeafNode(this_STRING_2, grammarAccess.getPathAccess().getSTRINGTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRulesentence
entryRulesentence returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSentenceRule()); }
	iv_rulesentence=rulesentence
	{ $current=$iv_rulesentence.current.getText(); }
	EOF;

// Rule sentence
rulesentence returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_GOOD_CHARS_NO_COLON_0=RULE_GOOD_CHARS_NO_COLON
		{
			$current.merge(this_GOOD_CHARS_NO_COLON_0);
		}
		{
			newLeafNode(this_GOOD_CHARS_NO_COLON_0, grammarAccess.getSentenceAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0());
		}
		    |
		this_STRING_1=RULE_STRING
		{
			$current.merge(this_STRING_1);
		}
		{
			newLeafNode(this_STRING_1, grammarAccess.getSentenceAccess().getSTRINGTerminalRuleCall_1());
		}
	)+
;

// Entry rule entryRulesentencePlusAssign
entryRulesentencePlusAssign returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSentencePlusAssignRule()); }
	iv_rulesentencePlusAssign=rulesentencePlusAssign
	{ $current=$iv_rulesentencePlusAssign.current.getText(); }
	EOF;

// Rule sentencePlusAssign
rulesentencePlusAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_GOOD_CHARS_NO_COLON_0=RULE_GOOD_CHARS_NO_COLON
		{
			$current.merge(this_GOOD_CHARS_NO_COLON_0);
		}
		{
			newLeafNode(this_GOOD_CHARS_NO_COLON_0, grammarAccess.getSentencePlusAssignAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0());
		}
		    |
		kw=':='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getSentencePlusAssignAccess().getColonEqualsSignKeyword_1());
		}
		    |
		this_STRING_2=RULE_STRING
		{
			$current.merge(this_STRING_2);
		}
		{
			newLeafNode(this_STRING_2, grammarAccess.getSentencePlusAssignAccess().getSTRINGTerminalRuleCall_2());
		}
	)+
;

RULE_STRING : '"' ~('"')* '"';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

fragment RULE_GOOD_CHAR_NO_COLON : ('!'..'9'|'<'..'~');

RULE_GOOD_CHARS_NO_COLON : RULE_GOOD_CHAR_NO_COLON+;
