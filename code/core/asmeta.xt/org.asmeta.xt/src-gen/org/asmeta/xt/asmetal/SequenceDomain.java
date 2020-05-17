/**
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.asmetal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.SequenceDomain#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getSequenceDomain()
 * @model
 * @generated
 */
public interface SequenceDomain extends StructuredTD
{
  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(Domain)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getSequenceDomain_Domain()
   * @model containment="true"
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.SequenceDomain#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

} // SequenceDomain
