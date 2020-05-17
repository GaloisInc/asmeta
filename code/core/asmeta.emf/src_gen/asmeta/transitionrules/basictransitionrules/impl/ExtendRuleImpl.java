/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package asmeta.transitionrules.basictransitionrules.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import asmeta.definitions.domains.Domain;
import asmeta.terms.basicterms.VariableTerm;
import asmeta.transitionrules.basictransitionrules.BasictransitionrulesPackage;
import asmeta.transitionrules.basictransitionrules.ExtendRule;
import asmeta.transitionrules.basictransitionrules.Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extend Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.impl.ExtendRuleImpl#getExtendedDomain <em>Extended Domain</em>}</li>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.impl.ExtendRuleImpl#getBoundVar <em>Bound Var</em>}</li>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.impl.ExtendRuleImpl#getDoRule <em>Do Rule</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtendRuleImpl extends BasicRuleImpl implements ExtendRule {
	/**
	 * The cached value of the '{@link #getExtendedDomain() <em>Extended Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain extendedDomain;

	/**
	 * The cached value of the '{@link #getBoundVar() <em>Bound Var</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundVar()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableTerm> boundVar;

	/**
	 * The cached value of the '{@link #getDoRule() <em>Do Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoRule()
	 * @generated
	 * @ordered
	 */
	protected Rule doRule;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasictransitionrulesPackage.Literals.EXTEND_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Domain getExtendedDomain() {
		if (extendedDomain != null && extendedDomain.eIsProxy()) {
			InternalEObject oldExtendedDomain = (InternalEObject)extendedDomain;
			extendedDomain = (Domain)eResolveProxy(oldExtendedDomain);
			if (extendedDomain != oldExtendedDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BasictransitionrulesPackage.EXTEND_RULE__EXTENDED_DOMAIN, oldExtendedDomain, extendedDomain));
			}
		}
		return extendedDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetExtendedDomain() {
		return extendedDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtendedDomain(Domain newExtendedDomain) {
		Domain oldExtendedDomain = extendedDomain;
		extendedDomain = newExtendedDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.EXTEND_RULE__EXTENDED_DOMAIN, oldExtendedDomain, extendedDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VariableTerm> getBoundVar() {
		if (boundVar == null) {
			boundVar = new EObjectContainmentEList<VariableTerm>(VariableTerm.class, this, BasictransitionrulesPackage.EXTEND_RULE__BOUND_VAR);
		}
		return boundVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rule getDoRule() {
		return doRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDoRule(Rule newDoRule, NotificationChain msgs) {
		Rule oldDoRule = doRule;
		doRule = newDoRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.EXTEND_RULE__DO_RULE, oldDoRule, newDoRule);
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
	public void setDoRule(Rule newDoRule) {
		if (newDoRule != doRule) {
			NotificationChain msgs = null;
			if (doRule != null)
				msgs = ((InternalEObject)doRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BasictransitionrulesPackage.EXTEND_RULE__DO_RULE, null, msgs);
			if (newDoRule != null)
				msgs = ((InternalEObject)newDoRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BasictransitionrulesPackage.EXTEND_RULE__DO_RULE, null, msgs);
			msgs = basicSetDoRule(newDoRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.EXTEND_RULE__DO_RULE, newDoRule, newDoRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasictransitionrulesPackage.EXTEND_RULE__BOUND_VAR:
				return ((InternalEList<?>)getBoundVar()).basicRemove(otherEnd, msgs);
			case BasictransitionrulesPackage.EXTEND_RULE__DO_RULE:
				return basicSetDoRule(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasictransitionrulesPackage.EXTEND_RULE__EXTENDED_DOMAIN:
				if (resolve) return getExtendedDomain();
				return basicGetExtendedDomain();
			case BasictransitionrulesPackage.EXTEND_RULE__BOUND_VAR:
				return getBoundVar();
			case BasictransitionrulesPackage.EXTEND_RULE__DO_RULE:
				return getDoRule();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasictransitionrulesPackage.EXTEND_RULE__EXTENDED_DOMAIN:
				setExtendedDomain((Domain)newValue);
				return;
			case BasictransitionrulesPackage.EXTEND_RULE__BOUND_VAR:
				getBoundVar().clear();
				getBoundVar().addAll((Collection<? extends VariableTerm>)newValue);
				return;
			case BasictransitionrulesPackage.EXTEND_RULE__DO_RULE:
				setDoRule((Rule)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case BasictransitionrulesPackage.EXTEND_RULE__EXTENDED_DOMAIN:
				setExtendedDomain((Domain)null);
				return;
			case BasictransitionrulesPackage.EXTEND_RULE__BOUND_VAR:
				getBoundVar().clear();
				return;
			case BasictransitionrulesPackage.EXTEND_RULE__DO_RULE:
				setDoRule((Rule)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BasictransitionrulesPackage.EXTEND_RULE__EXTENDED_DOMAIN:
				return extendedDomain != null;
			case BasictransitionrulesPackage.EXTEND_RULE__BOUND_VAR:
				return boundVar != null && !boundVar.isEmpty();
			case BasictransitionrulesPackage.EXTEND_RULE__DO_RULE:
				return doRule != null;
		}
		return super.eIsSet(featureID);
	}

} //ExtendRuleImpl
