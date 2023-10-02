/**
 * generated by Xtext 2.32.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.RuleDomain#getDomains <em>Domains</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getRuleDomain()
 * @model
 * @generated
 */
public interface RuleDomain extends StructuredTD
{
  /**
   * Returns the value of the '<em><b>Domains</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Domain}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domains</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getRuleDomain_Domains()
   * @model containment="true"
   * @generated
   */
  EList<Domain> getDomains();

} // RuleDomain
