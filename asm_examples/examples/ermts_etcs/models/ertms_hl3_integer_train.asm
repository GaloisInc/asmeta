asm ertms_hl3_integer_train

//	Visual reference model

//	  VSS_11		 VSS_12	    VSS_21	  VSS_22		 VSS_23	   VSS_31	  VSS_32		 VSS_33
// |----------|----------|----------|----------|----------|----------|----------|----------|
// 0			 10			20		   30		 40			50		   60		  70			80
//{		   TTD_10		}{			   TTD_20			}{				TTD_30			 }
//
// Step 1 			Train_Position		Train_Length		Train_Speed			MA(Start,End)
//
// Train1				45					10				100				  (40,60)
// Train2				20					 5				 50				  (10,35)
//
// Means: Train1 occupies the VSS_23 and VSS_22 and is running from VSS_22 to VSS_31
//		  Train2 occupies the VSS_12 and is running from VSS_11 to VSS_22


import ../../../STDL/StandardLibrary

signature:	

//	Agents	
	domain Trains subsetof Agent 
	domain Rbc subsetof Agent
	domain TrackController subsetof Agent	
	
	abstract domain Vss 
	abstract domain Ttd  
	
	domain Vss_Count subsetof Integer
	domain Ttd_Count subsetof Integer
	domain Train_Count subsetof Integer
	domain Track_Count subsetof Integer
	domain Vss_Units subsetof Integer
	domain Train_Speed subsetof Integer


	enum domain Ttd_state = {TTD_FREE | TTD_OCCUPIED}
	enum domain Train_state = {LOSTINTEGRITY | NOTLOSTINTEGRITY | LENGTHCHANGED | NOTLENGTHCHANGED | INTEGRITYCONFIRMED | NOTINTEGRITYCONFIRMED | RECONNECTING | NOTRECONNECTING | CONNECTED | NOTCONNECTED | SHADOWTRAIN | NOTSHADOWTRAIN | GHOSTTRAIN | NOTGHOSTTRAIN }
	enum domain Vss_state = {UNKNOWN | AMBIGUOUS | FREE | OCCUPIED}

//	VSS States
    dynamic controlled vss_states: Vss -> Vss_state
	dynamic controlled vss_prestates: Vss -> Vss_state
	dynamic controlled integrityloss_propagation_timer: Vss -> Boolean
	derived last_vss_onthe_ttd: Ttd -> Vss
	derived vss_rear_train: Trains -> Vss
	derived vss_related_to_train_position: Vss_Units -> Vss
	derived position_related_to_vss: Vss -> Vss_Count

//	TTD States	
	dynamic controlled ttd_states: Ttd -> Ttd_state
	dynamic controlled ttd_prestates:  Ttd -> Ttd_state	
	derived ttd_rear_train: Trains -> Ttd
	derived train_on_ttd: Prod(Ttd, Trains) -> Boolean
	derived lefting_ttd_check_status_free: Ttd -> Ttd_state
	derived position_related_to_ttd: Ttd -> Ttd_Count
	derived ttd_related_to_absolute_position: Vss_Units -> Ttd_Count
	derived ttd_related_to_position: Vss_Units -> Ttd

//	TRAIN States	

	dynamic controlled trains_integer: Trains -> Boolean
	dynamic controlled trains_shadow: Trains -> Boolean
	dynamic controlled trains_confirmed_integrity: Trains -> Boolean
	dynamic controlled confirmed_safe_rear_end: Trains -> Vss_Units
	dynamic controlled train_state: Trains ->  Seq(Train_state)
	dynamic controlled train_prestate: Trains ->  Seq(Train_state)
	derived train_has_crossed_ttd: Trains -> Boolean
	derived train_left_vss : Trains -> Boolean
	derived train_is_rear_ttd: Prod(Ttd, Vss_Units) -> Boolean
	derived min_safe_rear_end: Trains -> Vss_Units
	derived train_rear_another_train: Prod(Trains, Trains) -> Boolean
	
	// Movement Authority for the train expressed in vss_unit
	dynamic monitored ma: Trains -> Prod(Vss_Units, Vss_Units)
	
	// trains position on the Trackside expressed in vss_unit 
	dynamic monitored train_position: Trains -> Vss_Units
	
	// trains length on the Trackside expressed in vss_unit
	dynamic monitored train_length: Trains -> Vss_Units
	
	// trains speed on the Trackside expressed in vss_unit
	dynamic monitored train_speed: Trains -> Train_Speed
	
	// disconnect propagation timer 
	dynamic monitored disconnect_propagation_timer: Vss -> Boolean
	
	// if mute_timer = true the communication session is considered as lost by the RBC
	dynamic controlled mute_timer: Trains -> Boolean
	
	dynamic controlled brake_factor: Real
	
// Collecting trains data (Position, Length, Speed....)
	dynamic controlled collect_trains_data: Trains -> Prod(Vss_Units, Vss_Units, Train_Speed, Vss_Units, Vss_Units) 
	dynamic controlled collect_trains_predata: Trains -> Prod(Vss_Units, Vss_Units, Train_Speed, Vss_Units, Vss_Units)
	
	static vss_11: Vss
	static vss_12: Vss
	static vss_21: Vss
	static vss_22: Vss
	static vss_23: Vss
	static vss_31: Vss
	static vss_32: Vss
	static vss_33: Vss
	
	static ttd_10: Ttd
	static ttd_20: Ttd
	static ttd_30: Ttd
	
	static train1: Trains
	static train2: Trains
	
	static rbc_supervisor: Rbc
	
	static trackcontroller1: TrackController
	
	monitored rbc_conn: Trains -> Boolean	
	monitored lost_integrity: Trains -> Boolean
	monitored wait_integrity_timer: Trains -> Boolean

definitions:

	domain Vss_Count = {1 : 8}
	domain Ttd_Count = {1 : 3}
	domain Train_Count = {1 : 1}
	domain Vss_Units = {1 : 80}  // means that each VSS is divided into 10 pieces
	domain Train_Speed = {0 : 200}
    			 

	function lefting_ttd_check_status_free($ttd in Ttd) = 
			
	            switch($ttd)
	            		case ttd_10:
					  if (vss_states(vss_11) = FREE and vss_states(vss_12) = OCCUPIED) then
					  	   	TTD_FREE 
					  else
					  		TTD_OCCUPIED	    
					  endif
					case ttd_20:   
					  if (vss_states(vss_21) = FREE and vss_states(vss_22) = FREE and vss_states(vss_23) = OCCUPIED) then
						   TTD_FREE
					  else
					  	   TTD_OCCUPIED		   
					  endif
					case ttd_30:  
					  if (vss_states(vss_31) = FREE and vss_states(vss_32) = FREE and vss_states(vss_33) = FREE) then
						   TTD_FREE
					  else
					  	   TTD_OCCUPIED		   
				 	  endif 
		 		endswitch                      

// VSS related to the train position
    function vss_related_to_train_position($train_position in Vss_Units) = 
			
			if ($train_position > 70) and ($train_position <= 80) then
			    vss_33
			else if ($train_position > 60) and ($train_position <= 70) then 
					vss_32
				 else if ($train_position > 50) and ($train_position <= 60) then
				         vss_31
				      else if ($train_position > 40) and ($train_position <= 50) then 
				              vss_23
				           else if ($train_position > 30) and ($train_position <= 40) then 
				                   vss_22
				                else if ($train_position > 20) and ($train_position <= 30) then  
				                        vss_21
				                      else if ($train_position > 10) and ($train_position <= 20) then  
				                              vss_12
				                           else if ($train_position >= 1) and ($train_position <= 10) then  
				                                   vss_11      
											   endif
										   endif
									 endif
								endif
						   endif	
					  endif
				 endif	  	   	 	   	   
			endif

// VSS rear	train
   	function vss_rear_train($trains in Trains) = 
								 
			 if (train_position($trains) - train_length($trains) + 1) > 70 then 
					vss_32
				 else if (train_position($trains) - train_length($trains) + 1) > 60 then
				         vss_31
				      else if (train_position($trains) - train_length($trains) + 1) > 50 then 
				              vss_23
				           else if (train_position($trains) - train_length($trains) + 1) > 40 then 
				                   vss_22
				                else if (train_position($trains) - train_length($trains) + 1) > 30 then  
				                        vss_21
				                      else if (train_position($trains) - train_length($trains) + 1) > 20 then  
				                              vss_12
				                           else if (train_position($trains) - train_length($trains) + 1) > 10 then 
				                                    vss_11  
				                                 else
				                                    vss_11    
				                                endif    		                           
										  endif
									 endif
								endif
						   endif	
					  endif
				 endif	  	   	 	   	   


    function position_related_to_ttd($ttd in Ttd) = 

			 switch($ttd)
			     case ttd_10:
			     				1
			     case ttd_20:
			     				2
			     case ttd_30:
			     				3
			 endswitch 
			 
	function ttd_related_to_absolute_position($trains_position in Vss_Units) = 

			if ($trains_position >= 51) and ($trains_position <= 80) then
			     3
			else if  ($trains_position >= 21) and ($trains_position < 50) then
			        2
			     else if ($trains_position >= 1) and ($trains_position <= 20) then       
						1
					  endif
				 endif	
			endif	   	
	
	function ttd_related_to_position($trains_position in Vss_Units) = 

			if ($trains_position >= 51) and ($trains_position <= 80) then
			     ttd_30
			else if  ($trains_position >= 21) and ($trains_position <= 50) then
			        ttd_20
			     else if ($trains_position >= 1) and ($trains_position <= 20) then       
						ttd_10
					  endif
				 endif	
			endif	
						
	function train_on_ttd($ttd in Ttd, $trains in Trains) =

			if (ttd_related_to_absolute_position(train_position($trains)) = position_related_to_ttd($ttd)) then
			        true
			else
					false
			endif	   					
			
	function train_left_vss($trains in Trains) = 
	
		  	    if vss_related_to_train_position((train_position($trains) - train_length($trains)) + 1) != vss_related_to_train_position((first(collect_trains_data($trains)) - second(collect_trains_data($trains))) + 1) then
			  	    true
			  	else
			  	    false
			  	endif       
			
	function ttd_rear_train($trains in Trains) = 
				
			if (train_position($trains) - train_length($trains) + 1) >= 51 and (train_position($trains) - train_length($trains)) <= 80 then
			      ttd_20
			else if  (train_position($trains) - train_length($trains) + 1) >= 21 and (train_position($trains) - train_length($trains)) <= 50 then
			          ttd_10
			      endif
			endif                 
	
	function last_vss_onthe_ttd($ttd in Ttd) =   
	
			switch($ttd)
			   case ttd_10:
			   				vss_12
			   case ttd_20:
			   				vss_23
			   case ttd_30:
			   				vss_33
			endswitch   								

// true if train1 is rear train2			 
	function train_rear_another_train($train1 in Trains, $train2 in Trains) =
	
	         if (train_position($train2) - train_length($train2) + 1) > train_position($train1) then 
	              true
	         else
	         	  false
	         endif	  
	         	       
	function min_safe_rear_end($trains in Trains) =  
	
			if train_speed($trains) > 0 then 
			  	rtoi(((itor(train_speed($trains)) / brake_factor) * (itor(train_speed($trains)) / brake_factor)) / ((itor(train_speed($trains)) * itor(train_length($trains))) / brake_factor))	  	
			else
				0
			endif	  	 		         	          	                 
	
	macro rule r_check_ttd_status_free ($ttd in Ttd) =	
	
			    if lefting_ttd_check_status_free($ttd) = TTD_FREE  and  ttd_states($ttd) = TTD_OCCUPIED then
			       par
					    ttd_states($ttd) := TTD_FREE
					    ttd_prestates($ttd) := ttd_states($ttd)
				   endpar
				endif   	 
	
	
	// set all trains vss to occupied			
	macro rule  r_vss_train_occupied ($trains in Trains) =	
	
			   forall $position in Vss_Units with (($position <= train_position($trains)) and ($position > (train_position($trains) - train_length($trains))) and $position <= second(ma($trains))) do
			     par
					 vss_states(vss_related_to_train_position($position)) := OCCUPIED
					 vss_prestates(vss_related_to_train_position($position)) := vss_states(vss_related_to_train_position($position))
					 ttd_states(ttd_related_to_position($position)) := TTD_OCCUPIED
					 ttd_prestates(ttd_related_to_position($position)) := ttd_states(ttd_related_to_position($position))						 							       					  
				 endpar	     					 					 					         
			              	              
      macro rule  r_collect_train_data ($trains in Trains) =
    
    			     par
    				    	collect_trains_data($trains) := (train_position($trains), train_length($trains), train_speed($trains), first(ma($trains)), second(ma($trains)))  
    				    	collect_trains_predata($trains) := collect_trains_data($trains)
    				 endpar    	  
    			       				             					
	macro rule r_check_rbc_trains_connection = 
	
		  forall $trains in Trains with true do	
			if not rbc_conn($trains) then 
			    par
			       mute_timer($trains) := true
			       trains_confirmed_integrity($trains) := false
			    endpar 
			else
			   par
				  mute_timer($trains) :=false
				  if contains(train_state($trains), NOTCONNECTED) then
				       trains_confirmed_integrity($trains) := false
				  else
				       trains_confirmed_integrity($trains) := true
				  endif          
			   endpar	  
			endif	    

// 3.5	Operation of trains treated as integer			
	macro rule r_Trains_integer ($trains in Trains) =
	   
	   par
			if trains_confirmed_integrity($trains) and train_position($trains) <= second(ma($trains))  and  rbc_conn($trains) then
			   par  
			     confirmed_safe_rear_end($trains) := train_position($trains) - train_length($trains) - min_safe_rear_end($trains)
			     if (first(train_prestate($trains)) = NOTLOSTINTEGRITY) and not(wait_integrity_timer($trains)) then
			           r_vss_train_occupied[$trains]     
			     endif
			   endpar  
			 else if train_left_vss($trains) and vss_states(vss_rear_train($trains)) = OCCUPIED and train_speed($trains) > 0 then 
			        par			                    
			            vss_states(vss_rear_train($trains)) := UNKNOWN
					    vss_prestates(vss_rear_train($trains)) := vss_states(vss_rear_train($trains))
			        endpar
			      endif       
			 endif        
			 forall $t in Trains with $t != $trains do
			   if (not(rbc_conn($t))) and train_rear_another_train($t, $trains) then
			          trains_shadow($trains) := true
			   else
			       par
			          trains_shadow($trains) := false
			          if train_left_vss($trains) and vss_states(vss_rear_train($trains)) = OCCUPIED then 			                 
	                      par				                         
			                   vss_states(vss_rear_train($trains)) := FREE
							   vss_prestates(vss_rear_train($trains)) := vss_states(vss_rear_train($trains))
							   if isDef(ttd_rear_train($trains)) then 
							      if not train_on_ttd(ttd_rear_train($trains), $t)  then
				   				     r_check_ttd_status_free[ttd_rear_train($trains)]
				   				  endif   
							   endif     
					      endpar        
			          endif 
			      endpar     
			   endif    
			endpar
      
	
	macro rule r_Trains_connected ($trains in Trains) =
				
				if rbc_conn($trains) then
	         		par
	         			confirmed_safe_rear_end($trains) := train_position($trains) - train_length($trains) - min_safe_rear_end($trains)    	                  	            	    
	            	   	 	mute_timer($trains) :=false
	            	   	 	if contains(train_state($trains), CONNECTED) then
	            	    		    trains_confirmed_integrity($trains) := true
	            	    		else
	            	    		    trains_confirmed_integrity($trains) := false
	            	    		endif       
	        	    		endpar
	        		else
	        	   		par
	        	    			mute_timer($trains) :=true
	            	    		trains_confirmed_integrity($trains) := false
	            		endpar        
	        		endif
		     										
	macro rule r_Trains_Run ($trains in Trains, $vss in Vss) =
	    
			par	    		
	  		   r_Trains_integer[$trains] 	
			   r_Trains_connected[$trains]
  			endpar	

	macro rule r_Rbc_Supervisor  =
		   			   
			   r_check_rbc_trains_connection[] 			   
	
	macro rule r_Trains_on_TrackSide =
		  		
	   par   
			   forall $position in Vss_Units with $position <= second(ma(self)) and $position >= first(ma(self)) do
			       r_Trains_Run[self, vss_related_to_train_position($position)] 
			   r_collect_train_data[self]     
		   endpar	       		    			        

	main rule r_Main = 
		  
		  par
			forall $trains in Trains with true do
					program($trains)
			forall $rbc in Rbc with true do
			        program($rbc)      
		  endpar	        

default init initial_state:
	
	function brake_factor = 4.0
	
	function vss_states ($vss in Vss) = FREE
	function vss_prestates ($vss in Vss) = FREE
	function integrityloss_propagation_timer($vss in Vss) = false
	
	function ttd_states($ttd in Ttd) = TTD_FREE
	function ttd_prestates($ttd in Ttd) = TTD_FREE
	
	function trains_integer($trains in Trains) = true
	function trains_shadow($trains in Trains) = false
	function trains_confirmed_integrity($trains in Trains) = true
	function confirmed_safe_rear_end($trains in Trains) = 0	
	
	function collect_trains_data($trains in Trains) = (0, 0, 0, 0, 0)
	function collect_trains_predata($trains in Trains) = (0, 0, 0, 0, 0)  
	function train_state($trains in Trains) = [NOTLOSTINTEGRITY,  NOTLENGTHCHANGED, CONNECTED, NOTSHADOWTRAIN, INTEGRITYCONFIRMED]
	function train_prestate($trains in Trains) = [NOTLOSTINTEGRITY,  NOTLENGTHCHANGED, CONNECTED, NOTSHADOWTRAIN, INTEGRITYCONFIRMED]
	function mute_timer($trains in Trains) = false                  	

	agent Trains: r_Trains_on_TrackSide[]
	agent Rbc: r_Rbc_Supervisor[]
	
	
		
		
		
		
