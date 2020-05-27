//applied flatteners: MCR FR ChR AR LR CaR NR 
asm macroRuleChoose_flat
import ../../../../../asm_examples/STDL/StandardLibrary

signature:
    enum domain Side = {LEFT | RIGHT}

    controlled position: Side
    monitored choice: Side
    derived chooseVar0: Side

definitions:

    function chooseVar0 = chooseone({$s62 in Side| eq($s62,choice) : $s62})


    main rule r_Main =
        if isDef(chooseVar0) then
            position := chooseVar0
        endif

default init s0:
    function position = LEFT
