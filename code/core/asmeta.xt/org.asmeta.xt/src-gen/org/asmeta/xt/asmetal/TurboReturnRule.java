/**
 * generated by Xtext 2.32.0
 */
package org.asmeta.xt.asmetal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Turbo Return Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.TurboReturnRule#getLocation <em>Location</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.TurboReturnRule#getUpdateRule <em>Update Rule</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getTurboReturnRule()
 * @model
 * @generated
 */
public interface TurboReturnRule extends Rule
{
  /**
   * Returns the value of the '<em><b>Location</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' containment reference.
   * @see #setLocation(BasicTerm)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getTurboReturnRule_Location()
   * @model containment="true"
   * @generated
   */
  BasicTerm getLocation();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.TurboReturnRule#getLocation <em>Location</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Location</em>' containment reference.
   * @see #getLocation()
   * @generated
   */
  void setLocation(BasicTerm value);

  /**
   * Returns the value of the '<em><b>Update Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update Rule</em>' containment reference.
   * @see #setUpdateRule(TurboCallRule)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getTurboReturnRule_UpdateRule()
   * @model containment="true"
   * @generated
   */
  TurboCallRule getUpdateRule();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.TurboReturnRule#getUpdateRule <em>Update Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update Rule</em>' containment reference.
   * @see #getUpdateRule()
   * @generated
   */
  void setUpdateRule(TurboCallRule value);

} // TurboReturnRule
