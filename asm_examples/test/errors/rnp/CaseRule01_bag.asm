// il parser fallisce a leggere i bag 5 giugno 09 AG
asm CaseRule01_bag
import ../../STDL/StandardLibrary

signature:
controlled f: Integer

definitions:
main rule r_main =
	switch <1,4,9,16>
		case <>: skip
		case < $x in <1..16> : $x * $x> :
                        switch 77
				case 0: skip
				otherwise f := 88
			endswitch
		otherwise f := 99
	endswitch
