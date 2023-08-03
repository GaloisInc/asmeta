/**
 * generated by Xtext 2.31.0
 */
package org.asmeta.avallaxt.avalla.util;

import org.asmeta.avallaxt.avalla.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.asmeta.avallaxt.avalla.AvallaPackage
 * @generated
 */
public class AvallaSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AvallaPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AvallaSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AvallaPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case AvallaPackage.SCENARIO:
      {
        Scenario scenario = (Scenario)theEObject;
        T result = caseScenario(scenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.INVARIANT:
      {
        Invariant invariant = (Invariant)theEObject;
        T result = caseInvariant(invariant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.ELEMENT:
      {
        Element element = (Element)theEObject;
        T result = caseElement(element);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.COMMAND:
      {
        Command command = (Command)theEObject;
        T result = caseCommand(command);
        if (result == null) result = caseElement(command);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.CHECK:
      {
        Check check = (Check)theEObject;
        T result = caseCheck(check);
        if (result == null) result = caseCommand(check);
        if (result == null) result = caseElement(check);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.SET:
      {
        Set set = (Set)theEObject;
        T result = caseSet(set);
        if (result == null) result = caseCommand(set);
        if (result == null) result = caseElement(set);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.STEP_UNTIL:
      {
        StepUntil stepUntil = (StepUntil)theEObject;
        T result = caseStepUntil(stepUntil);
        if (result == null) result = caseCommand(stepUntil);
        if (result == null) result = caseElement(stepUntil);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.EXEC:
      {
        Exec exec = (Exec)theEObject;
        T result = caseExec(exec);
        if (result == null) result = caseCommand(exec);
        if (result == null) result = caseElement(exec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.BLOCK:
      {
        Block block = (Block)theEObject;
        T result = caseBlock(block);
        if (result == null) result = caseElement(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.EXEC_BLOCK:
      {
        ExecBlock execBlock = (ExecBlock)theEObject;
        T result = caseExecBlock(execBlock);
        if (result == null) result = caseCommand(execBlock);
        if (result == null) result = caseElement(execBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AvallaPackage.STEP:
      {
        Step step = (Step)theEObject;
        T result = caseStep(step);
        if (result == null) result = caseCommand(step);
        if (result == null) result = caseElement(step);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScenario(Scenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invariant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invariant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvariant(Invariant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommand(Command object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Check</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Check</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCheck(Check object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSet(Set object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Step Until</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Step Until</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStepUntil(StepUntil object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExec(Exec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlock(Block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exec Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exec Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecBlock(ExecBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStep(Step object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //AvallaSwitch
