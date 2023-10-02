/**
 * generated by Xtext 2.32.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.Signature#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Signature#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getSignature()
 * @model
 * @generated
 */
public interface Signature extends EObject
{
  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Domain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getSignature_Domain()
   * @model containment="true"
   * @generated
   */
  EList<Domain> getDomain();

  /**
   * Returns the value of the '<em><b>Function</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Function}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getSignature_Function()
   * @model containment="true"
   * @generated
   */
  EList<Function> getFunction();

  org.asmeta.xt.asmetal.Header getHeaderSection();
} // Signature
