/**
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.FunctionDefinition#getDefinedFunctionName <em>Defined Function Name</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.FunctionDefinition#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.FunctionDefinition#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.FunctionDefinition#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getFunctionDefinition()
 * @model
 * @generated
 */
public interface FunctionDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Defined Function Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defined Function Name</em>' attribute.
   * @see #setDefinedFunctionName(String)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getFunctionDefinition_DefinedFunctionName()
   * @model
   * @generated
   */
  String getDefinedFunctionName();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.FunctionDefinition#getDefinedFunctionName <em>Defined Function Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defined Function Name</em>' attribute.
   * @see #getDefinedFunctionName()
   * @generated
   */
  void setDefinedFunctionName(String value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' attribute list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getFunctionDefinition_Variables()
   * @model unique="false"
   * @generated
   */
  EList<String> getVariables();

  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Domain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getFunctionDefinition_Domain()
   * @model containment="true"
   * @generated
   */
  EList<Domain> getDomain();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Term)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getFunctionDefinition_Body()
   * @model containment="true"
   * @generated
   */
  Term getBody();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.FunctionDefinition#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Term value);

  org.asmeta.xt.asmetal.Function getDefinedFunction();
  
  java.util.List<org.asmeta.xt.asmetal.VariableTerm> getVariable();
} // FunctionDefinition
