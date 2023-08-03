/*
 * generated by Xtext 2.31.0
 */
grammar InternalAvalla;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package org.asmeta.avallaxt.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.asmeta.avallaxt.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.asmeta.avallaxt.services.AvallaGrammarAccess;

}
@parser::members {
	private AvallaGrammarAccess grammarAccess;

	public void setGrammarAccess(AvallaGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleScenario
entryRuleScenario
:
{ before(grammarAccess.getScenarioRule()); }
	 ruleScenario
{ after(grammarAccess.getScenarioRule()); } 
	 EOF 
;

// Rule Scenario
ruleScenario 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenarioAccess().getGroup()); }
		(rule__Scenario__Group__0)
		{ after(grammarAccess.getScenarioAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleInvariant
entryRuleInvariant
:
{ before(grammarAccess.getInvariantRule()); }
	 ruleInvariant
{ after(grammarAccess.getInvariantRule()); } 
	 EOF 
;

// Rule Invariant
ruleInvariant 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getInvariantAccess().getGroup()); }
		(rule__Invariant__Group__0)
		{ after(grammarAccess.getInvariantAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleElement
entryRuleElement
:
{ before(grammarAccess.getElementRule()); }
	 ruleElement
{ after(grammarAccess.getElementRule()); } 
	 EOF 
;

// Rule Element
ruleElement 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getElementAccess().getAlternatives()); }
		(rule__Element__Alternatives)
		{ after(grammarAccess.getElementAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCommand
entryRuleCommand
:
{ before(grammarAccess.getCommandRule()); }
	 ruleCommand
{ after(grammarAccess.getCommandRule()); } 
	 EOF 
;

// Rule Command
ruleCommand 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCommandAccess().getAlternatives()); }
		(rule__Command__Alternatives)
		{ after(grammarAccess.getCommandAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleCheck
entryRuleCheck
:
{ before(grammarAccess.getCheckRule()); }
	 ruleCheck
{ after(grammarAccess.getCheckRule()); } 
	 EOF 
;

// Rule Check
ruleCheck 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCheckAccess().getGroup()); }
		(rule__Check__Group__0)
		{ after(grammarAccess.getCheckAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleSet
entryRuleSet
:
{ before(grammarAccess.getSetRule()); }
	 ruleSet
{ after(grammarAccess.getSetRule()); } 
	 EOF 
;

// Rule Set
ruleSet 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSetAccess().getGroup()); }
		(rule__Set__Group__0)
		{ after(grammarAccess.getSetAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStep
entryRuleStep
:
{ before(grammarAccess.getStepRule()); }
	 ruleStep
{ after(grammarAccess.getStepRule()); } 
	 EOF 
;

// Rule Step
ruleStep 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStepAccess().getStepKeyword()); }
		'step'
		{ after(grammarAccess.getStepAccess().getStepKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleStepUntil
entryRuleStepUntil
:
{ before(grammarAccess.getStepUntilRule()); }
	 ruleStepUntil
{ after(grammarAccess.getStepUntilRule()); } 
	 EOF 
;

// Rule StepUntil
ruleStepUntil 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getStepUntilAccess().getGroup()); }
		(rule__StepUntil__Group__0)
		{ after(grammarAccess.getStepUntilAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExec
entryRuleExec
:
{ before(grammarAccess.getExecRule()); }
	 ruleExec
{ after(grammarAccess.getExecRule()); } 
	 EOF 
;

// Rule Exec
ruleExec 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExecAccess().getGroup()); }
		(rule__Exec__Group__0)
		{ after(grammarAccess.getExecAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBlock
entryRuleBlock
:
{ before(grammarAccess.getBlockRule()); }
	 ruleBlock
{ after(grammarAccess.getBlockRule()); } 
	 EOF 
;

// Rule Block
ruleBlock 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBlockAccess().getGroup()); }
		(rule__Block__Group__0)
		{ after(grammarAccess.getBlockAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleExecBlock
entryRuleExecBlock
:
{ before(grammarAccess.getExecBlockRule()); }
	 ruleExecBlock
{ after(grammarAccess.getExecBlockRule()); } 
	 EOF 
;

// Rule ExecBlock
ruleExecBlock 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getExecBlockAccess().getGroup()); }
		(rule__ExecBlock__Group__0)
		{ after(grammarAccess.getExecBlockAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePath
entryRulePath
:
{ before(grammarAccess.getPathRule()); }
	 rulePath
{ after(grammarAccess.getPathRule()); } 
	 EOF 
;

// Rule Path
rulePath 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPathAccess().getAlternatives()); }
		(rule__Path__Alternatives)
		{ after(grammarAccess.getPathAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulesentence
entryRulesentence
:
{ before(grammarAccess.getSentenceRule()); }
	 rulesentence
{ after(grammarAccess.getSentenceRule()); } 
	 EOF 
;

// Rule sentence
rulesentence 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getSentenceAccess().getAlternatives()); }
			(rule__Sentence__Alternatives)
			{ after(grammarAccess.getSentenceAccess().getAlternatives()); }
		)
		(
			{ before(grammarAccess.getSentenceAccess().getAlternatives()); }
			(rule__Sentence__Alternatives)*
			{ after(grammarAccess.getSentenceAccess().getAlternatives()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulesentencePlusAssign
entryRulesentencePlusAssign
:
{ before(grammarAccess.getSentencePlusAssignRule()); }
	 rulesentencePlusAssign
{ after(grammarAccess.getSentencePlusAssignRule()); } 
	 EOF 
;

// Rule sentencePlusAssign
rulesentencePlusAssign 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getSentencePlusAssignAccess().getAlternatives()); }
			(rule__SentencePlusAssign__Alternatives)
			{ after(grammarAccess.getSentencePlusAssignAccess().getAlternatives()); }
		)
		(
			{ before(grammarAccess.getSentencePlusAssignAccess().getAlternatives()); }
			(rule__SentencePlusAssign__Alternatives)*
			{ after(grammarAccess.getSentencePlusAssignAccess().getAlternatives()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getElementAccess().getCommandParserRuleCall_0()); }
		ruleCommand
		{ after(grammarAccess.getElementAccess().getCommandParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getElementAccess().getBlockParserRuleCall_1()); }
		ruleBlock
		{ after(grammarAccess.getElementAccess().getBlockParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCommandAccess().getCheckParserRuleCall_0()); }
		ruleCheck
		{ after(grammarAccess.getCommandAccess().getCheckParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getCommandAccess().getSetParserRuleCall_1()); }
		ruleSet
		{ after(grammarAccess.getCommandAccess().getSetParserRuleCall_1()); }
	)
	|
	(
		{ before(grammarAccess.getCommandAccess().getGroup_2()); }
		(rule__Command__Group_2__0)
		{ after(grammarAccess.getCommandAccess().getGroup_2()); }
	)
	|
	(
		{ before(grammarAccess.getCommandAccess().getStepUntilParserRuleCall_3()); }
		ruleStepUntil
		{ after(grammarAccess.getCommandAccess().getStepUntilParserRuleCall_3()); }
	)
	|
	(
		{ before(grammarAccess.getCommandAccess().getExecParserRuleCall_4()); }
		ruleExec
		{ after(grammarAccess.getCommandAccess().getExecParserRuleCall_4()); }
	)
	|
	(
		{ before(grammarAccess.getCommandAccess().getExecBlockParserRuleCall_5()); }
		ruleExecBlock
		{ after(grammarAccess.getCommandAccess().getExecBlockParserRuleCall_5()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Path__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		(
			{ before(grammarAccess.getPathAccess().getAlternatives_0()); }
			(rule__Path__Alternatives_0)
			{ after(grammarAccess.getPathAccess().getAlternatives_0()); }
		)
		(
			{ before(grammarAccess.getPathAccess().getAlternatives_0()); }
			(rule__Path__Alternatives_0)*
			{ after(grammarAccess.getPathAccess().getAlternatives_0()); }
		)
	)
	|
	(
		{ before(grammarAccess.getPathAccess().getSTRINGTerminalRuleCall_1()); }
		RULE_STRING
		{ after(grammarAccess.getPathAccess().getSTRINGTerminalRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Path__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPathAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getPathAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getPathAccess().getColonKeyword_0_1()); }
		':'
		{ after(grammarAccess.getPathAccess().getColonKeyword_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Sentence__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSentenceAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getSentenceAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getSentenceAccess().getSTRINGTerminalRuleCall_1()); }
		RULE_STRING
		{ after(grammarAccess.getSentenceAccess().getSTRINGTerminalRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__SentencePlusAssign__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSentencePlusAssignAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getSentencePlusAssignAccess().getGOOD_CHARS_NO_COLONTerminalRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getSentencePlusAssignAccess().getColonEqualsSignKeyword_1()); }
		':='
		{ after(grammarAccess.getSentencePlusAssignAccess().getColonEqualsSignKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getSentencePlusAssignAccess().getSTRINGTerminalRuleCall_2()); }
		RULE_STRING
		{ after(grammarAccess.getSentencePlusAssignAccess().getSTRINGTerminalRuleCall_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario__Group__0__Impl
	rule__Scenario__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenarioAccess().getScenarioKeyword_0()); }
	'scenario'
	{ after(grammarAccess.getScenarioAccess().getScenarioKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario__Group__1__Impl
	rule__Scenario__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenarioAccess().getNameAssignment_1()); }
	(rule__Scenario__NameAssignment_1)
	{ after(grammarAccess.getScenarioAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario__Group__2__Impl
	rule__Scenario__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenarioAccess().getLoadKeyword_2()); }
	'load'
	{ after(grammarAccess.getScenarioAccess().getLoadKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario__Group__3__Impl
	rule__Scenario__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenarioAccess().getSpecAssignment_3()); }
	(rule__Scenario__SpecAssignment_3)
	{ after(grammarAccess.getScenarioAccess().getSpecAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario__Group__4__Impl
	rule__Scenario__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenarioAccess().getInvariantsAssignment_4()); }
	(rule__Scenario__InvariantsAssignment_4)*
	{ after(grammarAccess.getScenarioAccess().getInvariantsAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenarioAccess().getElementsAssignment_5()); }
	(rule__Scenario__ElementsAssignment_5)*
	{ after(grammarAccess.getScenarioAccess().getElementsAssignment_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Invariant__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Invariant__Group__0__Impl
	rule__Invariant__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInvariantAccess().getInvariantKeyword_0()); }
	'invariant'
	{ after(grammarAccess.getInvariantAccess().getInvariantKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Invariant__Group__1__Impl
	rule__Invariant__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInvariantAccess().getNameAssignment_1()); }
	(rule__Invariant__NameAssignment_1)
	{ after(grammarAccess.getInvariantAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Invariant__Group__2__Impl
	rule__Invariant__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInvariantAccess().getColonKeyword_2()); }
	':'
	{ after(grammarAccess.getInvariantAccess().getColonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Invariant__Group__3__Impl
	rule__Invariant__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInvariantAccess().getExpressionAssignment_3()); }
	(rule__Invariant__ExpressionAssignment_3)
	{ after(grammarAccess.getInvariantAccess().getExpressionAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Invariant__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getInvariantAccess().getSemicolonKeyword_4()); }
	';'
	{ after(grammarAccess.getInvariantAccess().getSemicolonKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Command__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Command__Group_2__0__Impl
	rule__Command__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCommandAccess().getStepAction_2_0()); }
	()
	{ after(grammarAccess.getCommandAccess().getStepAction_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Command__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Command__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCommandAccess().getStepParserRuleCall_2_1()); }
	ruleStep
	{ after(grammarAccess.getCommandAccess().getStepParserRuleCall_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Check__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Check__Group__0__Impl
	rule__Check__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Check__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCheckAccess().getCheckKeyword_0()); }
	'check'
	{ after(grammarAccess.getCheckAccess().getCheckKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Check__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Check__Group__1__Impl
	rule__Check__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Check__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCheckAccess().getExpressionAssignment_1()); }
	(rule__Check__ExpressionAssignment_1)
	{ after(grammarAccess.getCheckAccess().getExpressionAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Check__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Check__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Check__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCheckAccess().getSemicolonKeyword_2()); }
	';'
	{ after(grammarAccess.getCheckAccess().getSemicolonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Set__Group__0__Impl
	rule__Set__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSetAccess().getSetKeyword_0()); }
	'set'
	{ after(grammarAccess.getSetAccess().getSetKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Set__Group__1__Impl
	rule__Set__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSetAccess().getLocationAssignment_1()); }
	(rule__Set__LocationAssignment_1)
	{ after(grammarAccess.getSetAccess().getLocationAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Set__Group__2__Impl
	rule__Set__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSetAccess().getColonEqualsSignKeyword_2()); }
	':='
	{ after(grammarAccess.getSetAccess().getColonEqualsSignKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Set__Group__3__Impl
	rule__Set__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSetAccess().getValueAssignment_3()); }
	(rule__Set__ValueAssignment_3)
	{ after(grammarAccess.getSetAccess().getValueAssignment_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Set__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getSetAccess().getSemicolonKeyword_4()); }
	';'
	{ after(grammarAccess.getSetAccess().getSemicolonKeyword_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__StepUntil__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StepUntil__Group__0__Impl
	rule__StepUntil__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStepUntilAccess().getStepKeyword_0()); }
	'step'
	{ after(grammarAccess.getStepUntilAccess().getStepKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StepUntil__Group__1__Impl
	rule__StepUntil__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStepUntilAccess().getUntilKeyword_1()); }
	'until'
	{ after(grammarAccess.getStepUntilAccess().getUntilKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StepUntil__Group__2__Impl
	rule__StepUntil__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStepUntilAccess().getExpressionAssignment_2()); }
	(rule__StepUntil__ExpressionAssignment_2)
	{ after(grammarAccess.getStepUntilAccess().getExpressionAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__StepUntil__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getStepUntilAccess().getSemicolonKeyword_3()); }
	';'
	{ after(grammarAccess.getStepUntilAccess().getSemicolonKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Exec__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exec__Group__0__Impl
	rule__Exec__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Exec__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecAccess().getExecKeyword_0()); }
	'exec'
	{ after(grammarAccess.getExecAccess().getExecKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exec__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exec__Group__1__Impl
	rule__Exec__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Exec__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecAccess().getRuleAssignment_1()); }
	(rule__Exec__RuleAssignment_1)
	{ after(grammarAccess.getExecAccess().getRuleAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exec__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Exec__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Exec__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecAccess().getSemicolonKeyword_2()); }
	';'
	{ after(grammarAccess.getExecAccess().getSemicolonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Block__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group__0__Impl
	rule__Block__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getBeginKeyword_0()); }
	'begin'
	{ after(grammarAccess.getBlockAccess().getBeginKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group__1__Impl
	rule__Block__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getNameAssignment_1()); }
	(rule__Block__NameAssignment_1)
	{ after(grammarAccess.getBlockAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group__2__Impl
	rule__Block__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getElementsAssignment_2()); }
	(rule__Block__ElementsAssignment_2)*
	{ after(grammarAccess.getBlockAccess().getElementsAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Block__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBlockAccess().getEndKeyword_3()); }
	'end'
	{ after(grammarAccess.getBlockAccess().getEndKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ExecBlock__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExecBlock__Group__0__Impl
	rule__ExecBlock__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecBlockAccess().getExecblockKeyword_0()); }
	'execblock'
	{ after(grammarAccess.getExecBlockAccess().getExecblockKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExecBlock__Group__1__Impl
	rule__ExecBlock__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecBlockAccess().getGroup_1()); }
	(rule__ExecBlock__Group_1__0)?
	{ after(grammarAccess.getExecBlockAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExecBlock__Group__2__Impl
	rule__ExecBlock__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecBlockAccess().getBlockAssignment_2()); }
	(rule__ExecBlock__BlockAssignment_2)
	{ after(grammarAccess.getExecBlockAccess().getBlockAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExecBlock__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecBlockAccess().getSemicolonKeyword_3()); }
	';'
	{ after(grammarAccess.getExecBlockAccess().getSemicolonKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ExecBlock__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExecBlock__Group_1__0__Impl
	rule__ExecBlock__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecBlockAccess().getScenarioAssignment_1_0()); }
	(rule__ExecBlock__ScenarioAssignment_1_0)
	{ after(grammarAccess.getExecBlockAccess().getScenarioAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ExecBlock__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getExecBlockAccess().getColonKeyword_1_1()); }
	':'
	{ after(grammarAccess.getExecBlockAccess().getColonKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Scenario__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenarioAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getScenarioAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__SpecAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenarioAccess().getSpecPathParserRuleCall_3_0()); }
		rulePath
		{ after(grammarAccess.getScenarioAccess().getSpecPathParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__InvariantsAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenarioAccess().getInvariantsInvariantParserRuleCall_4_0()); }
		ruleInvariant
		{ after(grammarAccess.getScenarioAccess().getInvariantsInvariantParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario__ElementsAssignment_5
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenarioAccess().getElementsElementParserRuleCall_5_0()); }
		ruleElement
		{ after(grammarAccess.getScenarioAccess().getElementsElementParserRuleCall_5_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInvariantAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getInvariantAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Invariant__ExpressionAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getInvariantAccess().getExpressionSentenceParserRuleCall_3_0()); }
		rulesentence
		{ after(grammarAccess.getInvariantAccess().getExpressionSentenceParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Check__ExpressionAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCheckAccess().getExpressionSentenceParserRuleCall_1_0()); }
		rulesentence
		{ after(grammarAccess.getCheckAccess().getExpressionSentenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__LocationAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSetAccess().getLocationSentenceParserRuleCall_1_0()); }
		rulesentence
		{ after(grammarAccess.getSetAccess().getLocationSentenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__ValueAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getSetAccess().getValueSentenceParserRuleCall_3_0()); }
		rulesentence
		{ after(grammarAccess.getSetAccess().getValueSentenceParserRuleCall_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__StepUntil__ExpressionAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getStepUntilAccess().getExpressionSentenceParserRuleCall_2_0()); }
		rulesentence
		{ after(grammarAccess.getStepUntilAccess().getExpressionSentenceParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Exec__RuleAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExecAccess().getRuleSentencePlusAssignParserRuleCall_1_0()); }
		rulesentencePlusAssign
		{ after(grammarAccess.getExecAccess().getRuleSentencePlusAssignParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBlockAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getBlockAccess().getNameGOOD_CHARS_NO_COLONTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Block__ElementsAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBlockAccess().getElementsElementParserRuleCall_2_0()); }
		ruleElement
		{ after(grammarAccess.getBlockAccess().getElementsElementParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__ScenarioAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExecBlockAccess().getScenarioGOOD_CHARS_NO_COLONTerminalRuleCall_1_0_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getExecBlockAccess().getScenarioGOOD_CHARS_NO_COLONTerminalRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ExecBlock__BlockAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getExecBlockAccess().getBlockGOOD_CHARS_NO_COLONTerminalRuleCall_2_0()); }
		RULE_GOOD_CHARS_NO_COLON
		{ after(grammarAccess.getExecBlockAccess().getBlockGOOD_CHARS_NO_COLONTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_STRING : '"' ~('"')* '"';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

fragment RULE_GOOD_CHAR_NO_COLON : ('!'..'9'|'<'..'~');

RULE_GOOD_CHARS_NO_COLON : RULE_GOOD_CHAR_NO_COLON+;
