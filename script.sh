#!/bin/bash
BOARD_MAX=${1:-4}

function move {
 TMP="$1.3.1."
 WIN_SIZE=3
 for (( k=0; k<$WIN_SIZE; k++ ))
 do
   TMP="$TMP$(($2)) $(($3+$k))."
   TMP="${TMP}_ _."
 done
 echo $TMP
}
function hor {
  WIN_ROW=$(($1 - 3 + 1))
  for (( i = 0; i<$1; i++ ))
  do
    for (( z = 0; z<$WIN_ROW; z++ ))
    do
      move $1 $i $z
    done
  done
}
#rozmiar
for (( i=3; i<=$BOARD_MAX; i++ ))
do
  #echo "Rozmiar planszy: $i"
  hor $i
done

