/**
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.asmetal.impl;

import org.asmeta.xt.asmetal.AbstractTD;
import org.asmeta.xt.asmetal.AsmetalPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract TD</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.impl.AbstractTDImpl#isDynamic <em>Dynamic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractTDImpl extends TypeDomainImpl implements AbstractTD
{
  /**
   * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamic()
   * @generated
   * @ordered
   */
  protected static final boolean DYNAMIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamic()
   * @generated
   * @ordered
   */
  protected boolean dynamic = DYNAMIC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractTDImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AsmetalPackage.Literals.ABSTRACT_TD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDynamic()
  {
    return dynamic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDynamic(boolean newDynamic)
  {
    boolean oldDynamic = dynamic;
    dynamic = newDynamic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AsmetalPackage.ABSTRACT_TD__DYNAMIC, oldDynamic, dynamic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AsmetalPackage.ABSTRACT_TD__DYNAMIC:
        return isDynamic();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AsmetalPackage.ABSTRACT_TD__DYNAMIC:
        setDynamic((Boolean)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AsmetalPackage.ABSTRACT_TD__DYNAMIC:
        setDynamic(DYNAMIC_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AsmetalPackage.ABSTRACT_TD__DYNAMIC:
        return dynamic != DYNAMIC_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (dynamic: ");
    result.append(dynamic);
    result.append(')');
    return result.toString();
  }

  public boolean getIsDynamic()
  {
  	return this.isDynamic();
  }
} //AbstractTDImpl
