/**
 * generated by Xtext 2.32.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term As Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.TermAsRule#getTerm <em>Term</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.TermAsRule#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getTermAsRule()
 * @model
 * @generated
 */
public interface TermAsRule extends Rule
{
  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(BasicTerm)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getTermAsRule_Term()
   * @model containment="true"
   * @generated
   */
  BasicTerm getTerm();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.TermAsRule#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(BasicTerm value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Term}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getTermAsRule_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Term> getParameters();

  void setTerm(org.asmeta.xt.asmetal.Term t);
  
} // TermAsRule
