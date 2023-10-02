/**
 * generated by Xtext 2.32.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#isIsAsynchr <em>Is Asynchr</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#getType <em>Type</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#getName <em>Name</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#getHeaderSection <em>Header Section</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#getBodySection <em>Body Section</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#getMainrule <em>Mainrule</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.Asm#getDefaultInitialState <em>Default Initial State</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm()
 * @model
 * @generated
 */
public interface Asm extends EObject
{
  /**
   * Returns the value of the '<em><b>Is Asynchr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Asynchr</em>' attribute.
   * @see #setIsAsynchr(boolean)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_IsAsynchr()
   * @model
   * @generated
   */
  boolean isIsAsynchr();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.Asm#isIsAsynchr <em>Is Asynchr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Asynchr</em>' attribute.
   * @see #isIsAsynchr()
   * @generated
   */
  void setIsAsynchr(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.Asm#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.Asm#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Header Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Header Section</em>' containment reference.
   * @see #setHeaderSection(Header)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_HeaderSection()
   * @model containment="true"
   * @generated
   */
  Header getHeaderSection();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.Asm#getHeaderSection <em>Header Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Header Section</em>' containment reference.
   * @see #getHeaderSection()
   * @generated
   */
  void setHeaderSection(Header value);

  /**
   * Returns the value of the '<em><b>Body Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body Section</em>' containment reference.
   * @see #setBodySection(Body)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_BodySection()
   * @model containment="true"
   * @generated
   */
  Body getBodySection();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.Asm#getBodySection <em>Body Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body Section</em>' containment reference.
   * @see #getBodySection()
   * @generated
   */
  void setBodySection(Body value);

  /**
   * Returns the value of the '<em><b>Mainrule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mainrule</em>' containment reference.
   * @see #setMainrule(MacroDeclaration)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_Mainrule()
   * @model containment="true"
   * @generated
   */
  MacroDeclaration getMainrule();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.Asm#getMainrule <em>Mainrule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mainrule</em>' containment reference.
   * @see #getMainrule()
   * @generated
   */
  void setMainrule(MacroDeclaration value);

  /**
   * Returns the value of the '<em><b>Initial State</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Initialization}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial State</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_InitialState()
   * @model containment="true"
   * @generated
   */
  EList<Initialization> getInitialState();

  /**
   * Returns the value of the '<em><b>Default Initial State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Initial State</em>' containment reference.
   * @see #setDefaultInitialState(Initialization)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getAsm_DefaultInitialState()
   * @model containment="true"
   * @generated
   */
  Initialization getDefaultInitialState();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.Asm#getDefaultInitialState <em>Default Initial State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Initial State</em>' containment reference.
   * @see #getDefaultInitialState()
   * @generated
   */
  void setDefaultInitialState(Initialization value);

} // Asm
