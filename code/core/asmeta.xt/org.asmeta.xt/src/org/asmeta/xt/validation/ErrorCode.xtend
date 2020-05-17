package org.asmeta.xt.validation

class ErrorCode {
	
	// ASM ERROR
	public static val ASM__INVALID_NAME 			= 'ASM_INVALID_NAME'
	public static val ASM__INVALID_MAINRULE_ARITY 	= 'ASM_INVALID_MAINRULE_ARITY'
	
	// ASM WARNING
	public static val ASM__MODULE_MAINRULE 			= 'ASM_MODULE_MAINRULE'
	public static val ASM__MODULE_DEF_INITIAL_STATE = 'ASM_MODULE_DEF_INITIAL_STATE'
	public static val ASM__MODULE_INITIAL_STATE		= 'ASM_MODULE_INITIAL_STATE'	
	
	// IMPORT ERROR
	public static val IMPORT_CLAUSE__FILE_NOT_FOUND		= 'IMPORT_CLAUSE__FILE_NOT_FOUND'
	public static val IMPORT_CLAUSE__NOT_FOUND 			= 'IMPORT_CLAUSE__NOT_FOUND'
	public static val IMPORT_CLAUSE__CALLED_TWICE 		= 'IMPORT_CLAUSE__CALLED_TWICE'	
	
	// IMPORT WARNING
	public static val IMPORT_CLAUSE__NOTHING_TO_IMPORT 	= 'IMPORT_CLAUSE__NOTHING_TO_IMPORT'

	// EXPORT ERROR
	public static val EXPORT_CLAUSE__NOTHING_TO_EXPORT	= 'EXPORT_CLAUSE__NOTHING_TO_EXPORT'
	public static val EXPORT_CLAUSE__NOT_FOUND			= 'EXPORT_CLAUSE__NOT_FOUND'
	public static val EXPORT_CLAUSE__CALLED_TWICE 		= 'EXPORT_CLAUSE__CALLED_TWICE'
	
	// SIGNATURE ERROR
	public static val SIGNATURE__DOMAIN_DEFINED_TWICE 	= 'SIGNATURE__DOMAIN_DEFINED_TWICE'
	public static val SIGNATURE__FUNCTION_DEFINED_TWICE = 'SIGNATURE__FUNCTION_DEFINED_TWICE'
	public static val SIGNATURE__DOMAIN_NOT_FOUND 		= 'SIGNATURE__DOMAIN_NOT_FOUND'
	public static val SIGNATURE__DOMAIN_NOT_IMPORTED	= 'SIGNATURE__DOMAIN_NOT_IMPORTED'
	public static val SIGNATURE__FUNCTION_NOT_FOUND		= 'SIGNATURE__FUNCTION_NOT_FOUND'
	public static val SIGNATURE__FUNCTION_NOT_IMPORTED	= 'SIGNATURE__FUNCTION_NOT_IMPORTED'
	
	// CONCRETE DOMAIN ERROR
	public static val CONCRETE_DOMAIN__INVALID_TYPE_DOMAIN 	= 'CONCRETE_DOMAIN__INVALID_TYPE_DOMAIN'
	
	// ENUM DOMAIN ERROR
	public static val ENUM_DOMAIN_ALREADY_DECLARED	= 'ENUM_DOMAIN_ALREADY_DECLARED'
	
	// BASIC TD ERROR
	public static val BASIC_DOMAIN__INVALID_NAME	= 'BASIC_DOMAIN__INVALID_NAME'
	
	// LOCAL FUNCTION ERROR
	public static val LOCAL_FUNCTION__INVALID_DECLARATION = 'LOCAL_FUNCTION__INVALID_DECLARATION'
	
	// BODY ERROR
	public static val BODY__RULE_NOT_IMPORTED = 'BODY_RULE__NOT_IMPORTED'
	public static val BODY__RULE_NOT_FOUND = 'BODY_RULE__NOT_FOUND'
	
	// DOMAIN DEFINITION ERROR
	public static val DOMAIN_DEFINITION__DOMAIN_NOT_CONCRETE = 'DOMAIN_DEFINITION__DOMAIN_NOT_CONCRETE'
	public static val DOMAIN_DEFINITION__IS_DYNAMIC_DOMAIN = 'DOMAIN_DEFINITION__IS_DYNAMIC_DOMAIN'
	public static val DOMAIN_DEFINITION__DEFINED_TWICE = 'DOMAIN_DEFINITION__DEFINED_TWICE'
	public static val DOMAIN_DEFINITION__ILL_FORMED_BODY = 'DOMAIN_DEFINITION__ILL_FORMED_BODY'
	
	// FUNCTION DEFINITION ERROR
	public static val FUNCTION_DEFINITION__FUNCTION_NOT_STATIC_DERIVED = 'FUNCTION_DEFINITION__FUNCTION_NOT_STATIC_DERIVED'
	public static val FUNCTION_DEFINITION__INVALID_ARITY = 'FUNCTION_DEFINITION__INVALID_ARITY'
	public static val FUNCTION_DEFINITION__INVALID_VARIABLE = 'FUNCTION_DEFINITION__INVALID_VARIABLE'
	public static val FUNCTION_DEFINITION__ILL_FORMED_BODY = 'FUNCTION_DEFINITION__ILL_FORMED_BODY'
	public static val FUNCTION_DEFINITION__DEFINED_TWICE = 'FUNCTION_DEFINITION__DEFINED_TWICE'
	
	// RULE DECLARATION ERROR
	public static val RULE_DECLARATION__DEFINED_TWICE = 'RULE_DECLARATION__DEFINED_TWICE'
	public static val RULE_DECLARATION__INVALID_VARIABLE = 'RULE_DECLARATION__INVALID_VARIABLE'
	
	// CONSTRAINTS ERROR
	public static val CONSTRAINT_DOMAIN_BODY_NOT_BOOLEAN = 'CONSTRAINT_DOMAIN_BODY_NOT_BOOLEAN'
	
	// INVARIANT ERROR
	public static val INVARINT__NOT_FOUND 			= 'INVARINT__NOT_FOUND'
	public static val INVARINT__CALLED_TWICE 		= 'INVARINT__CALLED_TWICE'	
	
	// CTL SPEC ERROR
	public static val CTL_SPEC__DUPLICATE_NAME = 'CTL_SPEC__DUPLICATE_NAME'
	
	// LTL SPEC ERROR
	public static val LTL_SPEC__DUPLICATE_NAME = 'LTL_SPEC__DUPLICATE_NAME'
	
	// INITIALIZATION ERROR
	public static val INITILIZATION_EMPTY_INIT = 'INITILIZATION_EMPTY_INIT'
	
	// DOMAIN INITIALIZATION ERROR
	public static val DOMAIN_INIZIALIZATION__DEFINED_TWICE = 'DOMAIN_INIZIALIZATION__DEFINED_TWICE'
	public static val DOMAIN_INIZIALIZATION__IS_STATIC = 'DOMAIN_INIZIALIZATION__IS_STATIC'
	public static val DOMAIN_INIZIALIZATION__ILL_FORMED_BODY = 'DOMAIN_INIZIALIZATION__ILL_FORMED_BODY'
	
	// FUNCTION INITIALIZATION ERROR
	public static val FUNCTION_INIZIALIZATION__FUNCTION_NOT_DYNAMIC = 'FUNCTION_INIZIALIZATION__FUNCTION_NOT_DYNAMIC'
	public static val FUNCTION_INIZIALIZATION__INVALID_ARITY = 'FUNCTION_INIZIALIZATION__INVALID_ARITY'
	public static val FUNCTION_INIZIALIZATION__INVALID_VARIABLE = 'FUNCTION_INIZIALIZATION__INVALID_VARIABLE'
	public static val FUNCTION_INIZIALIZATION__DEFINED_TWICE = 'FUNCTION_INIZIALIZATION__DEFINED_TWICE'
	public static val FUNCTION_INIZIALIZATION__ILL_FORMED_BODY = 'FUNCTION_INIZIALIZATION__ILL_FORMED_BODY'
	
	// AGENT INIZIALIZATION ERROR
	public static val AGENT_INIZIALIZATION__PROGRAM_NOT_FOUND = 'AGENT_INIZIALIZATION__PROGRAM_NOT_FOUND'
	public static val AGENT_INIZIALIZATION__INVALID_DOMAIN = 'AGENT_INIZIALIZATION__INVALID_DOMAIN'
	public static val AGENT_INIZIALIZATION__AGENT_DOMAIN_NOT_DECLARED = 'AGENT_INIZIALIZATION__AGENT_DOMAIN_NOT_DECLARED'

	// FUNCTION TERM ERROR
	public static val FUNCTION_TERM__ANY_DOMAIN_NOT_DECLARED = 'FUNCTION_TERM__ANY_DOMAIN_NOT_DECLARED'
	public static val FUNCTION_TERM__INVALID_ARITY_FOR_ZERO_ARITY = 'FUNCTION_TERM__INVALID_ARITY_FOR_ZERO_ARITY'
	public static val FUNCTION_TERM__INVALID_ARITY_FOR_N_ARITY = 'FUNCTION_TERM__INVALID_ARITY_FOR_N_ARITY'
	
	// TERM ERROR
	public static val TERM__DOMAIN_GUARD_NOT_BOOLEAN = 'TERM__DOMAIN_GUARD_NOT_BOOLEAN'
	
	// CONDITIONAL TERM ERROR
	public static val CONDITIONAL_TERM__IF_ELSE_DOMAIN_NOT_COMPATIBLE = 'CONDITIONAL_TERM__IF_ELSE_DOMAIN_NOT_COMPATIBLE'
	
	// CASE TERM ERROR
	public static val CASE_TERM__RESULT_TERM_DOMAIN_NOT_COMPATIBLE = 'CASE_TERM__RESULT_TERM_DOMAIN_NOT_COMPATIBLE'
	public static val CASE_TERM__OTHERWISE_DOMAIN_NOT_COMPATIBLE = 'CASE_TERM__OTHERWISE_DOMAIN_NOT_COMPATIBLE'
	public static val CASE_TERM__COMPARED_AND_COMPARING_DOMAIN_NOT_COMPATIBLE = 'CASE_TERM__COMPARED_AND_COMPARING_DOMAIN_NOT_COMPATIBLE'
	// ENUM TERM ERROR
	public static val ENUM_TERM__SYMBOL_NOT_FOUND = 'ENUM_TERM__SYMBOL_NOT_FOUND'

	// SET TERM ERROR
	public static val SET_TERM__ANY_DOMAIN_NOT_DECLARED = 'SET_TERM__ANY_DOMAIN_NOT_DECLARED'
	public static val SET_TERM__ADDED_TWICE = 'SET_TERM__ADDED_TWICE'
	public static val SET_TERM__DIFFERENT_DOMAINS = 'SET_TERM__DIFFERENT_DOMAINS'
	public static val SET_TERM__STEP_NEGATIVE = 'SET_TERM__STEP_NEGATIVE'
	public static val SET_TERM__STEP_NAN = 'SET_TERM__STEP_NAN'
	
	// BAG TERM ERROR
	public static val BAG_TERM__ANY_DOMAIN_NOT_DECLARED = 'BAG_TERM__ANY_DOMAIN_NOT_DECLARED'
	public static val BAG_TERM__ADDED_TWICE = 'BAG_TERM__ADDED_TWICE'
	public static val BAG_TERM__DIFFERENT_DOMAINS = 'BAG_TERM__DIFFERENT_DOMAINS'
	public static val BAG_TERM__STEP_NEGATIVE = 'BAG_TERM__STEP_NEGATIVE'
	public static val BAG_TERM__STEP_NAN = 'BAG_TERM__STEP_NAN'
	
	// SEQUENCE TERM ERROR
	public static val SEQUENCE_TERM__ANY_DOMAIN_NOT_DECLARED = 'SEQUENCE_TERM__ANY_DOMAIN_NOT_DECLARED'
	public static val SEQUENCE_TERM__ADDED_TWICE = 'SEQUENCE_TERM__ADDED_TWICE'
	public static val SEQUENCE_TERM__DIFFERENT_DOMAINS = 'SEQUENCE_TERM__DIFFERENT_DOMAINS'
	public static val SEQUENCE_TERM__STEP_NEGATIVE = 'SEQUENCE_TERM__STEP_NEGATIVE'
	public static val SEQUENCE_TERM__STEP_NAN = 'SEQUENCE_TERM__STEP_NAN'
	
	// MAP TERM ERROR
	public static val MAP_TERM__ANY_DOMAIN_NOT_DECLARED = 'MAP_TERM__ANY_DOMAIN_NOT_DECLARED'
	public static val MAP_TERM__DIFFERENT_DOMAINS = 'MAP_TERM__DIFFERENT_DOMAINS'
	
	// LET TERM ERROR
	public static val LET_TERM__VARIABLE_ALREADY_USED = 'LET_TERM__VARIABLE_ALREADY_USED'
	
	// FINITE QUANTIFICATION ERROR
	public static val FINITE_QUANT_TERM__VARIABLE_DOMAIN_NOT_POWERSET = 'FINITE_QUANT_TERM__VARIABLE_DOMAIN_NOT_POWERSET'
	
	// FORALL TERM ERROR
	public static val FORALL_TERM__VARIABLE_ALREADY_USED = 'FORALL_TERM__VARIABLE_ALREADY_USED'
	
	// EXIST TERM ERROR
	public static val EXIST_TERM__VARIABLE_ALREADY_USED = 'EXIST_TERM__VARIABLE_ALREADY_USED'

	// EXIST UNIQUE TERM ERROR
	public static val EXIST_UNIQUE_TERM__VARIABLE_ALREADY_USED = 'EXIST_UNIQUE_TERM__VARIABLE_ALREADY_USED'
	
	// SET CT TERM ERROR
	public static val SET_CT_TERM__VARIABLE_DOMAIN_NOT_POWERSET = 'SET_CT_TERM__VARIABLE_DOMAIN_NOT_POWERSET'
	public static val SET_CT_TERM__VARIABLE_ALREADY_USED = 'SET_CT_TERM__VARIABLE_ALREADY_USED'
	
	// MAP CT TERM ERROR
	public static val MAP_CT_TERM__VARIABLE_DOMAIN_NOT_POWERSET = 'MAP_CT_TERM__VARIABLE_DOMAIN_NOT_POWERSET'
	public static val MAP_CT_TERM__VARIABLE_ALREADY_USED = 'MAP_CT_TERM__VARIABLE_ALREADY_USED'
	
	// BAG CT TERM ERROR
	public static val BAG_CT_TERM__VARIABLE_DOMAIN_NOT_BAG = 'BAG_CT_TERM__VARIABLE_DOMAIN_NOT_BAG'
	public static val BAG_CT_TERM__VARIABLE_ALREADY_USED = 'BAG_CT_TERM__VARIABLE_ALREADY_USED'
	
	// SEQUENCE CT TERM ERROR
	public static val SEQUENCE_CT_TERM__VARIABLE_DOMAIN_NOT_SEQUENCE = 'SEQUENCE_CT_TERM__VARIABLE_DOMAIN_NOT_SEQUENCE'
	public static val SEQUENCE_CT_TERM__VARIABLE_ALREADY_USED = 'SEQUENCE_CT_TERM__VARIABLE_ALREADY_USED'
	
	// LOCATION TERM ERROR
	public static val LOCATION_TERM__NOT_DYNAMIC = 'LOCATION_TERM__NOT_DYNAMIC'
	
	// VARIABLE TERM ERROR
	public static val VARIABLE_TERM__NOT_DECLARED = 'VARIABLE_TERM__NOT_DECLARED'
	
	// UPDATE RULE ERROR
	public static val UPDATE_RULE__INVALID_LOCATION = 'UPDATE_RULE__INVALID_LOCATION'
	public static val UPDATE_RULE__DOMAINS_NOT_COMPATIBLE = 'UPDATE_RULE__DOMAINS_NOT_COMPATIBLE'
	public static val UPDATE_RULE__INVALID_VARIABLE = 'UPDATE_RULE__INVALID_VARIABLE'
	
	// EXTENDED RULE ERROR
	public static val EXTENDED_RULE__INVALID_DOMAIN = 'EXTENDED_RULE__INVALID_DOMAIN'
	public static val EXTENDED_RULE__RESERVE_DOMAIN_NOT_DECLARED = 'EXTENDED_RULE__RESERVE_DOMAIN_NOT_DECLARED'
	public static val EXTENDED_RULE__VARIABLE_ALREADY_USED = 'EXTENDED_RULE__VARIABLE_ALREADY_USED'
	
	// CHOOSE RULE ERROR
	public static val CHOOSE_RULE__RANGE_NOT_POWERSET = 'CHOOSE_RULE__RANGE_NOT_POWERSET'
	public static val CHOOSE_RULE__DOMAINS_NOT_COMPATIBLE = 'CHOOSE_RULE__DOMAINS_NOT_COMPATIBLE'
	public static val CHOOSE_RULE__VARIABLE_ALREADY_USED = 'CHOOSE_RULE__VARIABLE_ALREADY_USED'
	
	// FORALL RULE ERROR
	public static val FORALL_RULE__RANGE_NOT_POWERSET = 'FORALL_RULE__RANGE_NOT_POWERSET'
	public static val FORALL_RULE__DOMAINS_NOT_COMPATIBLE = 'FORALL_RULE__DOMAINS_NOT_COMPATIBLE'
	public static val FORALL_RULE__VARIABLE_ALREADY_USED = 'FORALL_RULE__VARIABLE_ALREADY_USED'
	
	// LET RULE ERROR
	public static val LET_RULE__VARIABLE_ALREADY_USED = 'LET_RULE__VARIABLE_ALREADY_USED'
	
	// CASE RULE ERROR
	public static val CASE_RULE__BRANCH_DOMAIN_NOT_COMPATIBLE = 'CASE_RULE__BRANCH_DOMAIN_NOT_COMPATIBLE'
	
	public static val TERM_AS_RULE_CODOMAIN_NOT_RULE = 'TERM_AS_RULE_CODOMAIN_NOT_RULE'
	
}