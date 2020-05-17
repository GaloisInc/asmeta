/**
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent Initialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.AgentInitialization#getDomainName <em>Domain Name</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.AgentInitialization#getProgram <em>Program</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getAgentInitialization()
 * @model
 * @generated
 */
public interface AgentInitialization extends EObject
{
  /**
   * Returns the value of the '<em><b>Domain Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain Name</em>' attribute.
   * @see #setDomainName(String)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAgentInitialization_DomainName()
   * @model
   * @generated
   */
  String getDomainName();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.AgentInitialization#getDomainName <em>Domain Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain Name</em>' attribute.
   * @see #getDomainName()
   * @generated
   */
  void setDomainName(String value);

  /**
   * Returns the value of the '<em><b>Program</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Program</em>' containment reference.
   * @see #setProgram(MacroCallRule)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAgentInitialization_Program()
   * @model containment="true"
   * @generated
   */
  MacroCallRule getProgram();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.AgentInitialization#getProgram <em>Program</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Program</em>' containment reference.
   * @see #getProgram()
   * @generated
   */
  void setProgram(MacroCallRule value);

  org.asmeta.xt.asmetal.Domain getDomain();
} // AgentInitialization
