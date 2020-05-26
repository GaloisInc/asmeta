package org.asmeta.runtime_simulator;

import java.util.HashMap;
import java.util.Map;

import org.asmeta.animator.MyState;
import org.asmeta.simulator.Location;
import org.asmeta.simulator.State;
import org.asmeta.simulator.readers.InteractiveMFReader;
import org.asmeta.simulator.util.InputMismatchException;
import org.asmeta.simulator.util.Parser;
import org.asmeta.simulator.value.BooleanValue;
import org.asmeta.simulator.value.EnumValue;
import org.asmeta.simulator.value.IntegerValue;
import org.asmeta.simulator.value.RealValue;
import org.asmeta.simulator.value.ReserveValue;
import org.asmeta.simulator.value.SequenceValue;
import org.asmeta.simulator.value.SetValue;
import org.asmeta.simulator.value.StringValue;
import org.asmeta.simulator.value.TupleValue;
import org.asmeta.simulator.value.UndefValue;
import org.asmeta.simulator.value.Value;

import asmeta.definitions.Function;
import asmeta.definitions.domains.AbstractTd;
import asmeta.definitions.domains.BooleanDomain;
import asmeta.definitions.domains.ConcreteDomain;
import asmeta.definitions.domains.EnumTd;
import asmeta.definitions.domains.IntegerDomain;
import asmeta.definitions.domains.PowersetDomain;
import asmeta.definitions.domains.ProductDomain;
import asmeta.definitions.domains.RealDomain;
import asmeta.definitions.domains.SequenceDomain;
import asmeta.definitions.domains.StringDomain;
import asmeta.definitions.domains.UndefDomain;


/**
 * 
 * @author Simone Giusso
 * Create by AsmetaSservice for run Simulator. This class is also used for create environment (see start method of AsmetaSservice).
 */

public class AsmetaSserviceRun extends InteractiveMFReader{
	
	private static int id;	//Simulator's id give by AsmetaSservice
	private String locationToFind; //Location to find in list, set by readValue
	private static Map<Location, Value> monitored; //I must save here the monitored function thanks to readValue because after run the monitored are delete. It's static because extend.
	
	public AsmetaSserviceRun(int id) {
		super(System.in, System.out);
		this.id = id;
		monitored = new HashMap<Location, Value>();
	}
	
	public AsmetaSserviceRun() {
		super(System.in, System.out);
	}
	
	public void run(RunMode mode) {
		SimulatorRT sim = AsmetaSservice.getInstance().getSimulatorTable().get(id).getSim();
		
		if(mode == RunMode.RUN_ONE_STEP)
			sim.run(1);
		else if(mode == RunMode.RUN_UNTIL_EMPTY)
			sim.runUntilEmpty();
		
		state = sim.getCurrentState();
		
		State previousState = sim.previousState;
		
		//Set previous state
		AsmetaSservice.getInstance().getSimulatorTable().get(id).setPreviousState(new MyState(previousState.getContrLocs(false), null));
		
		//Update current State
		AsmetaSservice.getInstance().getSimulatorTable().get(id).setState(new MyState(state.getContrLocs(false), monitored));
	}
	
	/**
	 * Convert string value only for monitored.
	 * In this method I must save location and value of the monitored function because in the simulator this value are been delete
	 */
	@Override
	public Value readValue(Location location, State state) {
		Function func = location.getSignature();
		locationToFind = location.toString();
		
		Value value =  visit(func.getCodomain());
		
		monitored.put(location, value);
		return value;
	}
	
	/**
	 * Set the value of location only for monitored
	 */
	@Override
	public void readLine() {
		for(Map.Entry<String, String> m: AsmetaSservice.getInstance().getSimulatorTable().get(id).getLocationValue().entrySet()) {	//Find the value of a particular location in list
			if (m.getKey().equals(locationToFind)) {
				setLine(m.getValue());
				return;	//I Suppose that I found it
			}
		}
	}
	
	@Override
	public IntegerValue visit(IntegerDomain domain) throws InputMismatchException {
		IntegerValue value = null;
		
		readLine();
		value = new Parser(getLine()).visit(domain);

		return value;
	}

	@Override
	public RealValue visit(RealDomain domain) throws InputMismatchException {
		RealValue value = null;

		readLine();
		value = new Parser(getLine()).visit(domain);

		return value;
	}

	@Override
	public BooleanValue visit(BooleanDomain domain) throws InputMismatchException {
		BooleanValue value = null;

		readLine();
		value = new Parser(getLine()).visit(domain);
		
		return value;
	}

	@Override
	public UndefValue visit(UndefDomain domain) throws InputMismatchException {
		UndefValue value = null;
		getOut().println("Insert an undef constant:");
		
		readLine();
		value = new Parser(getLine()).visit(domain);
		
		return value;
	}

	@Override
	public StringValue visit(StringDomain domain) throws InputMismatchException {
		StringValue value = null;
		
		readLine();
		value = new Parser(getLine()).visit(domain);
		
		return value;
	}

	@Override
	public TupleValue visit(ProductDomain domain) throws InputMismatchException {
		TupleValue value = null;

		readLine();
		value = new Parser(getLine()).visit(domain);
		
		return value;
	}

	@Override
	public SetValue visit(PowersetDomain domain) throws InputMismatchException {
		SetValue value = null;
		getOut().println("Insert a set:");

		readLine();
		value = new Parser(getLine()).visit(domain);
		
		return value;
	}

	@Override
	public SequenceValue visit(SequenceDomain domain) throws InputMismatchException {
		SequenceValue value = null;
		
		readLine();
		value = new Parser(getLine()).visit(domain);
		
		return value;
	}

	@Override
	public ReserveValue visit(AbstractTd domain) throws InputMismatchException {
		ReserveValue value = null;

		readLine();
		value = new Parser(getLine()).visit(domain);
	
		if (!checkAbstract(domain, value)) {
			throw new InputMismatchException("The constant " + value + " doesn't belong to concrete domain " + domain.getName());
		}

		return value;
	}

	@Override
	public EnumValue visit(EnumTd domain) throws InputMismatchException {
		EnumValue value = null;

		readLine();
		value = new Parser(getLine()).visit(domain);

		if (!checkEnum(domain, value)) {
			throw new InputMismatchException("The constant " + value + " doesn't belong to concrete domain " + domain.getName());
		}

		return value;
	}

	@Override
	public Value visit(ConcreteDomain domain) throws InputMismatchException {
		Value value = null;

		readLine();
		value = new Parser(getLine()).visit(domain);

		if (!checkConcrete(domain, value)) {
			throw new InputMismatchException("The constant " + value + " doesn't belong to concrete domain " + domain.getName());
		}
			
		return value;
	}

}