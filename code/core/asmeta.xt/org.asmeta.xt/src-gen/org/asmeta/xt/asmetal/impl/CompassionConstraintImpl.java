/**
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.asmetal.impl;

import org.asmeta.xt.asmetal.AsmetalPackage;
import org.asmeta.xt.asmetal.CompassionConstraint;
import org.asmeta.xt.asmetal.Term;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compassion Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.impl.CompassionConstraintImpl#getP <em>P</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.impl.CompassionConstraintImpl#getQ <em>Q</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompassionConstraintImpl extends FairnessConstraintImpl implements CompassionConstraint
{
  /**
   * The cached value of the '{@link #getP() <em>P</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getP()
   * @generated
   * @ordered
   */
  protected Term p;

  /**
   * The cached value of the '{@link #getQ() <em>Q</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQ()
   * @generated
   * @ordered
   */
  protected Term q;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CompassionConstraintImpl()
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
    return AsmetalPackage.Literals.COMPASSION_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Term getP()
  {
    return p;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetP(Term newP, NotificationChain msgs)
  {
    Term oldP = p;
    p = newP;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AsmetalPackage.COMPASSION_CONSTRAINT__P, oldP, newP);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setP(Term newP)
  {
    if (newP != p)
    {
      NotificationChain msgs = null;
      if (p != null)
        msgs = ((InternalEObject)p).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.COMPASSION_CONSTRAINT__P, null, msgs);
      if (newP != null)
        msgs = ((InternalEObject)newP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.COMPASSION_CONSTRAINT__P, null, msgs);
      msgs = basicSetP(newP, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AsmetalPackage.COMPASSION_CONSTRAINT__P, newP, newP));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Term getQ()
  {
    return q;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQ(Term newQ, NotificationChain msgs)
  {
    Term oldQ = q;
    q = newQ;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AsmetalPackage.COMPASSION_CONSTRAINT__Q, oldQ, newQ);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQ(Term newQ)
  {
    if (newQ != q)
    {
      NotificationChain msgs = null;
      if (q != null)
        msgs = ((InternalEObject)q).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.COMPASSION_CONSTRAINT__Q, null, msgs);
      if (newQ != null)
        msgs = ((InternalEObject)newQ).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.COMPASSION_CONSTRAINT__Q, null, msgs);
      msgs = basicSetQ(newQ, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AsmetalPackage.COMPASSION_CONSTRAINT__Q, newQ, newQ));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AsmetalPackage.COMPASSION_CONSTRAINT__P:
        return basicSetP(null, msgs);
      case AsmetalPackage.COMPASSION_CONSTRAINT__Q:
        return basicSetQ(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case AsmetalPackage.COMPASSION_CONSTRAINT__P:
        return getP();
      case AsmetalPackage.COMPASSION_CONSTRAINT__Q:
        return getQ();
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
      case AsmetalPackage.COMPASSION_CONSTRAINT__P:
        setP((Term)newValue);
        return;
      case AsmetalPackage.COMPASSION_CONSTRAINT__Q:
        setQ((Term)newValue);
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
      case AsmetalPackage.COMPASSION_CONSTRAINT__P:
        setP((Term)null);
        return;
      case AsmetalPackage.COMPASSION_CONSTRAINT__Q:
        setQ((Term)null);
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
      case AsmetalPackage.COMPASSION_CONSTRAINT__P:
        return p != null;
      case AsmetalPackage.COMPASSION_CONSTRAINT__Q:
        return q != null;
    }
    return super.eIsSet(featureID);
  }

} //CompassionConstraintImpl
