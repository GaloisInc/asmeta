/**
 * generated by Xtext 2.32.0
 */
package org.asmeta.xt.asmetal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.IterateRule#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getIterateRule()
 * @model
 * @generated
 */
public interface IterateRule extends TurboRule
{
  /**
   * Returns the value of the '<em><b>Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' containment reference.
   * @see #setRule(Rule)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getIterateRule_Rule()
   * @model containment="true"
   * @generated
   */
  Rule getRule();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.IterateRule#getRule <em>Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' containment reference.
   * @see #getRule()
   * @generated
   */
  void setRule(Rule value);

} // IterateRule
