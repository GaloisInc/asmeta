/**
 * generated by Xtext 2.21.0
 */
package org.asmeta.xt.asmetal.impl;

import org.asmeta.xt.asmetal.AsmetalPackage;
import org.asmeta.xt.asmetal.ConditionalRule;
import org.asmeta.xt.asmetal.Rule;
import org.asmeta.xt.asmetal.Term;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.impl.ConditionalRuleImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.impl.ConditionalRuleImpl#getThenRule <em>Then Rule</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.impl.ConditionalRuleImpl#getElseRule <em>Else Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalRuleImpl extends BasicRuleImpl implements ConditionalRule
{
  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected Term guard;

  /**
   * The cached value of the '{@link #getThenRule() <em>Then Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenRule()
   * @generated
   * @ordered
   */
  protected Rule thenRule;

  /**
   * The cached value of the '{@link #getElseRule() <em>Else Rule</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseRule()
   * @generated
   * @ordered
   */
  protected Rule elseRule;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalRuleImpl()
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
    return AsmetalPackage.Literals.CONDITIONAL_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Term getGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(Term newGuard, NotificationChain msgs)
  {
    Term oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AsmetalPackage.CONDITIONAL_RULE__GUARD, oldGuard, newGuard);
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
  public void setGuard(Term newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.CONDITIONAL_RULE__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.CONDITIONAL_RULE__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AsmetalPackage.CONDITIONAL_RULE__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Rule getThenRule()
  {
    return thenRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenRule(Rule newThenRule, NotificationChain msgs)
  {
    Rule oldThenRule = thenRule;
    thenRule = newThenRule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AsmetalPackage.CONDITIONAL_RULE__THEN_RULE, oldThenRule, newThenRule);
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
  public void setThenRule(Rule newThenRule)
  {
    if (newThenRule != thenRule)
    {
      NotificationChain msgs = null;
      if (thenRule != null)
        msgs = ((InternalEObject)thenRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.CONDITIONAL_RULE__THEN_RULE, null, msgs);
      if (newThenRule != null)
        msgs = ((InternalEObject)newThenRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.CONDITIONAL_RULE__THEN_RULE, null, msgs);
      msgs = basicSetThenRule(newThenRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AsmetalPackage.CONDITIONAL_RULE__THEN_RULE, newThenRule, newThenRule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Rule getElseRule()
  {
    return elseRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseRule(Rule newElseRule, NotificationChain msgs)
  {
    Rule oldElseRule = elseRule;
    elseRule = newElseRule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE, oldElseRule, newElseRule);
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
  public void setElseRule(Rule newElseRule)
  {
    if (newElseRule != elseRule)
    {
      NotificationChain msgs = null;
      if (elseRule != null)
        msgs = ((InternalEObject)elseRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE, null, msgs);
      if (newElseRule != null)
        msgs = ((InternalEObject)newElseRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE, null, msgs);
      msgs = basicSetElseRule(newElseRule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE, newElseRule, newElseRule));
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
      case AsmetalPackage.CONDITIONAL_RULE__GUARD:
        return basicSetGuard(null, msgs);
      case AsmetalPackage.CONDITIONAL_RULE__THEN_RULE:
        return basicSetThenRule(null, msgs);
      case AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE:
        return basicSetElseRule(null, msgs);
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
      case AsmetalPackage.CONDITIONAL_RULE__GUARD:
        return getGuard();
      case AsmetalPackage.CONDITIONAL_RULE__THEN_RULE:
        return getThenRule();
      case AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE:
        return getElseRule();
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
      case AsmetalPackage.CONDITIONAL_RULE__GUARD:
        setGuard((Term)newValue);
        return;
      case AsmetalPackage.CONDITIONAL_RULE__THEN_RULE:
        setThenRule((Rule)newValue);
        return;
      case AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE:
        setElseRule((Rule)newValue);
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
      case AsmetalPackage.CONDITIONAL_RULE__GUARD:
        setGuard((Term)null);
        return;
      case AsmetalPackage.CONDITIONAL_RULE__THEN_RULE:
        setThenRule((Rule)null);
        return;
      case AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE:
        setElseRule((Rule)null);
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
      case AsmetalPackage.CONDITIONAL_RULE__GUARD:
        return guard != null;
      case AsmetalPackage.CONDITIONAL_RULE__THEN_RULE:
        return thenRule != null;
      case AsmetalPackage.CONDITIONAL_RULE__ELSE_RULE:
        return elseRule != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalRuleImpl
