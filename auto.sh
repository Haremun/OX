#!/usr/bin/expect
 
spawn ./run.sh
#wait for printing board
expect "*Input row and column:\r"
#send row and column to app
send -- "0 29\r"

expect "*Input row and column:\r" 
send -- "0 0\r"
expect "*Input row and column:\r" 
send -- "0 28\r"
expect "*Input row and column:\r" 
send -- "1 21\r"
expect "*Input row and column:\r" 
send -- "1 0\r"

expect eof
