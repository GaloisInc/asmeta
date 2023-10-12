asm pedestrian
 
import ../TimeLibrarySimple

signature:
	// DOMAINS
	enum domain CorssManagerStatus = {NORMAL | PEDESTRIAN | TRAM}	
	enum domain Lights = {RED | GREEN}
	
	//FUNCTIONS
	monitored crossManagerController: CorssManagerStatus
	monitored pedestrianComing: Boolean
	
	
	out pedestrianCall: Boolean
	out pedestrianLight: Lights	
	
	//TIMER

definitions:	

	 	
main rule r_Main =
	if crossManagerController = PEDESTRIAN then
		pedestrianLight := GREEN
	else
		par
			pedestrianLight := RED
			pedestrianCall := pedestrianComing
		endpar
	endif 

// INITIAL STATE
default init s0:	
 function pedestrianLight = RED	
 function pedestrianCall = false
 function crossManagerController = NORMAL

