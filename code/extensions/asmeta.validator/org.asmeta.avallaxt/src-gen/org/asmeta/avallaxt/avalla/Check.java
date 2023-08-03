/**
 * generated by Xtext 2.31.0
 */
package org.asmeta.avallaxt.avalla;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.avallaxt.avalla.Check#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.asmeta.avallaxt.avalla.AvallaPackage#getCheck()
 * @model
 * @generated
 */
public interface Check extends Command
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' attribute.
   * @see #setExpression(String)
   * @see org.asmeta.avallaxt.avalla.AvallaPackage#getCheck_Expression()
   * @model
   * @generated
   */
  String getExpression();

  /**
   * Sets the value of the '{@link org.asmeta.avallaxt.avalla.Check#getExpression <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' attribute.
   * @see #getExpression()
   * @generated
   */
  void setExpression(String value);

} // Check
