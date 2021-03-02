/**
 * generated by Xtext 2.24.0
 */
package org.asmeta.xt.asmetal;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.CaseRule#getTerm <em>Term</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.CaseRule#getCaseTerm <em>Case Term</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.CaseRule#getCaseBranch <em>Case Branch</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.CaseRule#getOtherwiseBranch <em>Otherwise Branch</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getCaseRule()
 * @model
 * @generated
 */
public interface CaseRule extends BasicDerivedRule
{
  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(Term)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getCaseRule_Term()
   * @model containment="true"
   * @generated
   */
  Term getTerm();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.CaseRule#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(Term value);

  /**
   * Returns the value of the '<em><b>Case Term</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Term}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case Term</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getCaseRule_CaseTerm()
   * @model containment="true"
   * @generated
   */
  EList<Term> getCaseTerm();

  /**
   * Returns the value of the '<em><b>Case Branch</b></em>' containment reference list.
   * The list contents are of type {@link org.asmeta.xt.asmetal.Rule}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case Branch</em>' containment reference list.
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getCaseRule_CaseBranch()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getCaseBranch();

  /**
   * Returns the value of the '<em><b>Otherwise Branch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Otherwise Branch</em>' containment reference.
   * @see #setOtherwiseBranch(Rule)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getCaseRule_OtherwiseBranch()
   * @model containment="true"
   * @generated
   */
  Rule getOtherwiseBranch();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.CaseRule#getOtherwiseBranch <em>Otherwise Branch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Otherwise Branch</em>' containment reference.
   * @see #getOtherwiseBranch()
   * @generated
   */
  void setOtherwiseBranch(Rule value);

  java.util.List<org.asmeta.xt.asmetal.Rule> getCaseBranches();
} // CaseRule
