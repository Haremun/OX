#!/usr/bin/expect

#Command to run
set cmd [lindex $argv 0]
#Split command to list of inputs
set lst [split $cmd "."]

#Run script
spawn ./run.sh 1

#Initialize board
expect "*size:\r"
send -- [lindex $lst 0]\r
expect "*win:\r"
send -- [lindex $lst 1]\r
expect "*2):\r"
send -- [lindex $lst 2]\r

#Input moves
for {set i 2} {$i<[llength $lst]} {incr i} {
	expect "*Input row and column:\r"
	send -- [lindex $lst $i]\r
}
expect "*Player X wins!"
