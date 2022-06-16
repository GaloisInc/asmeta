/*
 * generated by Xtext 2.14.0
 */
package org.asmeta.avallaxt.tests.syntax

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.asmeta.avallaxt.tests.AvallaInjectorProvider
import org.asmeta.avallaxt.avalla.Scenario
import org.asmeta.avallaxt.avalla.ExecBlock
import org.asmeta.avallaxt.avalla.Step
import org.asmeta.avallaxt.avalla.Block

@RunWith(XtextRunner)
@InjectWith(AvallaInjectorProvider)
class AvallaXtParsingInvariantTest {
	@Inject
	ParseHelper<Scenario> parseHelper
	
	@Test
	def void inv1() {
		test("x");
	}

	@Test
	def void inv2() {
		test("x + yy");
		test("f(x,6) + yy = 90");
	}

	@Test
	def void invmolte() {
		test("x > 0");
	}

	
	def void test(String i){
		println("testing with " + i)
		val scenario = "scenario scen load spec invariant myInv : "+ i + " ;";
		val result = parseHelper.parse(scenario)
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		Assert.assertEquals((result as Scenario).invariants.get(0).expression,i)
		
	}
}
