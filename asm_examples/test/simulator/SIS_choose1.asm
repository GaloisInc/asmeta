asm SIS_choose1
	
import ../../STDL/StandardLibrary
	
signature:
	
//domain WaterpressureType subsetof Natural

domain Waterpressuretype subsetof Natural

enum domain Switch = {ON | OFF}

enum domain Pressure = { TOOLOW |NORMAL |HIGH }

controlled waterpressure: Waterpressuretype 

monitored reset : Switch

monitored block : Switch

controlled pressure : Pressure

controlled overridden : Boolean

controlled safetyInjection : Switch

static low : Waterpressuretype

static permit : Waterpressuretype

definitions:
	
domain Waterpressuretype = {0n : 2000n}

function low = 900n

function permit = 1000n

macro rule r_wp = choose $x in Waterpressuretype 
                  with ( $x > waterpressure - 10n) and ($x < waterpressure + 10n)                   
                  do waterpressure := $x 

macro rule r_1 = 
           if ((waterpressure >= low) and (pressure = TOOLOW)) then
     
             pressure := NORMAL

           endif

macro rule r_2 = if (waterpressure >= permit) and (pressure = NORMAL) then  par

	  pressure := HIGH
	  overridden := false

          endpar     endif

macro rule r_3 = if waterpressure < low and pressure = NORMAL then 

        pressure := TOOLOW

	endif

macro rule r_4 = if waterpressure < permit and pressure = HIGH 

    then par pressure := NORMAL

         overridden := false

	endpar endif

macro rule r_5 = if reset = ON and 

    (pressure = TOOLOW or pressure = NORMAL)

    then overridden := false

    endif

macro rule r_6 =  if block = ON and 

      reset = OFF and pressure = TOOLOW 

    then overridden := true

    endif

macro rule r_7 =  if pressure = TOOLOW 

    then if overridden  

         then safetyInjection := OFF

         else safetyInjection := ON

         endif
    endif

macro rule r_8 =  if pressure != TOOLOW 

    then safetyInjection := OFF 

    endif

	
main rule r_SIS = par r_wp[] r_1[] r_2[] r_3[] r_4[] r_5[] r_6[] r_7[] endpar
	
default init s1:   

  function waterpressure = 12n

  function pressure = TOOLOW

  function reset = OFF

  function block = OFF

  function overridden = false

  function safetyInjection = OFF

   
