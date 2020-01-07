#!/usr/bin/expect
 
spawn ./run.sh
#wait for printing board
expect "*Input row and column:\r"
#send row and column to app
send -- "1 1\r"

expect "*Input row and column:\r" 
send -- "2 0\r"
expect "*Input row and column:\r" 
send -- "2 2\r"
expect "*Input row and column:\r" 
send -- "1 2\r"
expect "*Input row and column:\r" 
send -- "0 0\r"

expect eof
