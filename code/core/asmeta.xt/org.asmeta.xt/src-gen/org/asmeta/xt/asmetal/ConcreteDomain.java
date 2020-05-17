/**
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.asmetal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.ConcreteDomain#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.ConcreteDomain#getTypeDomain <em>Type Domain</em>}</li>
 * </ul>
 *
 * @see org.asmeta.xt.asmetal.AsmetalPackage#getConcreteDomain()
 * @model
 * @generated
 */
public interface ConcreteDomain extends Domain
{
  /**
   * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dynamic</em>' attribute.
   * @see #setDynamic(boolean)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getConcreteDomain_Dynamic()
   * @model
   * @generated
   */
  boolean isDynamic();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.ConcreteDomain#isDynamic <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dynamic</em>' attribute.
   * @see #isDynamic()
   * @generated
   */
  void setDynamic(boolean value);

  /**
   * Returns the value of the '<em><b>Type Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Domain</em>' containment reference.
   * @see #setTypeDomain(Domain)
   * @see org.asmeta.xt.asmetal.AsmetalPackage#getConcreteDomain_TypeDomain()
   * @model containment="true"
   * @generated
   */
  Domain getTypeDomain();

  /**
   * Sets the value of the '{@link org.asmeta.xt.asmetal.ConcreteDomain#getTypeDomain <em>Type Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Domain</em>' containment reference.
   * @see #getTypeDomain()
   * @generated
   */
  void setTypeDomain(Domain value);

  public boolean getIsDynamic();
  
  public DomainDefinition getDefinition();
} // ConcreteDomain
