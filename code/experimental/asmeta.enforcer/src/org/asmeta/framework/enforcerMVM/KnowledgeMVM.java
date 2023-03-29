package org.asmeta.framework.enforcerMVM;
import java.util.Map;
import org.asmeta.framework.enforcer.Knowledge;

public class KnowledgeMVM extends Knowledge {
	/** Keeps the times when the MAPE loop starts */
    //public List<Double> initTimeList = new ArrayList<Double>();    

    /** Keeps the times when the MAPE loop completes*/
    //public List<Double> endTimeList = new ArrayList<Double>();    
	
	/** Monitored values from the Controller*/ 
	Map<String, String> input; //user input for the Controller, and eventually sanitised by the enforcer
	Map<String, String> probes; //probing values as exposed by the Controller
	Map<String, String> effectors; //effector values for the Controller
	Map<String, String> output; //output as computed by the Controller, and eventually sanitised by the enforcer
	   

	public KnowledgeMVM() {
		super();
	}
   
	 //Overloading (by the new parameter); checks and eventually store the new system probing values if different
		public boolean systemStateChanged(Map<String, String> newProbes){

			if (probes == null || !probes.equals(newProbes)) {
				  probes = newProbes;
				  return true;
			  }
			//System.out.println("Probes values: "+probes.toString()+" UGUALE a: "+newProbes.toString()); 
			return false;
		}
		
		public void setEffectors(Map<String, String> newValues){
			effectors = newValues;
		}
		
		public Map<String, String> getEffectors(){
			return effectors;
		}
		
		public Map<String, String> getProbes(){
			return probes;
		}
		
		public Map<String, String> getInput(){
			return input;
		}
		
		public Map<String, String> getOutput(){
			return output;
		}
		
		public void setInput(Map<String, String> newInput){
			input = newInput;
		}
}
