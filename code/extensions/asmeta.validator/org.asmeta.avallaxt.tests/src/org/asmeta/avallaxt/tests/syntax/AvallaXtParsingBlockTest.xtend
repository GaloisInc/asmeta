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
import org.asmeta.avallaxt.avallaXt.Scenario
import org.asmeta.avallaxt.avallaXt.ExecBlock
import org.asmeta.avallaxt.avallaXt.Step
import org.asmeta.avallaxt.avallaXt.Block

@RunWith(XtextRunner)
@InjectWith(AvallaInjectorProvider)
class AvallaXtParsingBlockTest {
	@Inject
	ParseHelper<Scenario> parseHelper
	
	
	@Test
	def void checktest() {
		val result = parseHelper.parse('''
			scenario alpha
			load lll
			execblock sc1:blocco1; 
			
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		println((result as Scenario).elements.get(0))
		Assert.assertEquals("sc1",((result as Scenario).elements.get(0) as ExecBlock).scenario)
		Assert.assertEquals("blocco1",((result as Scenario).elements.get(0) as ExecBlock).block)
	}
	@Test
	def void checktestNOScenario() {
		val result = parseHelper.parse('''
			scenario alpha
			load lll
			execblock blocco1; 
			
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		println((result as Scenario).elements.get(0))
		Assert.assertNull(((result as Scenario).elements.get(0) as ExecBlock).scenario)
		Assert.assertEquals("blocco1",((result as Scenario).elements.get(0) as ExecBlock).block)
	}

	@Test
	def void checktestBlock() {
		val result = parseHelper.parse('''
			scenario alpha
			load lll
			begin blocco1
				step
			end 
			
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		val element = ((result as Scenario).elements.get(0) as Block).elements
		Assert.assertEquals(1,element.size);
		println(element)
		Assert.assertTrue(element.get(0) instanceof Step)
	}
	@Test
	def void checktestNestedBlock() {
		val result = parseHelper.parse('''
			scenario alpha
			load lll
			begin blocco1
				begin blocco2
				step
				end
			end 
			
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		println(((result as Scenario).elements.get(0) as Block).elements)
	}
}
