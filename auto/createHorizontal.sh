#!/bin/bash
BOARD_MAX=${1:-4}

function move {
 TMP="$1.3.1."
 WIN_SIZE=3
 #ruch X i O
 for (( k=0; k<$WIN_SIZE; k++ ))
 do
   TMP="$TMP$(($2)) $(($3+$k))."
   ROW=$(($2 + 1))
   if [ $ROW == $1 ]
   then
     ROW=0
   fi
   if [ $(($k+1)) != $WIN_SIZE ]
   then
     TMP="${TMP}$ROW $k."
   fi
 done
 TMP=`echo $TMP | sed 's/\.$//g'`
 echo $TMP
}
function hor {
  WIN_ROW=$(($1 - 3 + 1))
  #ilosc row
  for (( i = 0; i<$1; i++ ))
  do
    #ilosc wygranych w row
    for (( z = 0; z<$WIN_ROW; z++ ))
    do
      move $1 $i $z
    done
  done
}
#rozmiar planszy
for (( i=3; i<=$BOARD_MAX; i++ ))
do
  #echo "Rozmiar planszy: $i"
  hor $i
done

