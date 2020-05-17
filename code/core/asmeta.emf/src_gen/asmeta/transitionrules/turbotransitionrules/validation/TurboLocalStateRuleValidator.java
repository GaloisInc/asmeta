/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package asmeta.transitionrules.turbotransitionrules.validation;

import org.eclipse.emf.common.util.EList;

import asmeta.definitions.LocalFunction;
import asmeta.transitionrules.basictransitionrules.Rule;

/**
 * A sample validator interface for {@link asmeta.transitionrules.turbotransitionrules.TurboLocalStateRule}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TurboLocalStateRuleValidator {
	boolean validate();

	boolean validateInit(EList<Rule> value);
	boolean validateBody(Rule value);
	boolean validateLocalFunction(EList<LocalFunction> value);
}
