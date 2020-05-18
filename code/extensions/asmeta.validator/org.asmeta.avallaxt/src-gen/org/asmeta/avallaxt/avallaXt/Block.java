/**
 * generated by Xtext 2.17.0
 */
package org.asmeta.avallaxt.avallaXt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.avallaxt.avallaXt.Block#getName <em>Name</em>}</li>
 *   <li>{@link org.asmeta.avallaxt.avallaXt.Block#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.asmeta.avallaxt.avallaXt.AvallaXtPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends Element
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.asmeta.avallaxt.avallaXt.AvallaXtPackage#getBlock_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.asmeta.avallaxt.avallaXt.Block#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.avallaxt.avallaXt.Element}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.asmeta.avallaxt.avallaXt.AvallaXtPackage#getBlock_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Element> getElements();

} // Block
