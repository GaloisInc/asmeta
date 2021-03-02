/**
 * generated by Xtext 2.24.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.InvariantElement#getConstrainedName <em>Constrained Name</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.InvariantElement#getDomainList <em>Domain List</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getInvariantElement()
 * @model
 * @generated
 */
public interface InvariantElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Constrained Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constrained Name</em>' attribute.
   * @see #setConstrainedName(String)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getInvariantElement_ConstrainedName()
   * @model
   * @generated
   */
  String getConstrainedName();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.InvariantElement#getConstrainedName <em>Constrained Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constrained Name</em>' attribute.
   * @see #getConstrainedName()
   * @generated
   */
  void setConstrainedName(String value);

  /**
   * Returns the value of the '<em><b>Domain List</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Domain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain List</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getInvariantElement_DomainList()
   * @model containment="true"
   * @generated
   */
  EList<Domain> getDomainList();

} // InvariantElement
