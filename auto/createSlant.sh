#!/bin/bash
BOARD_MAX=${1:-4}

function move {
 TMP="$1.3.1."
 WIN_SIZE=3
 #ruch X i O
 for (( k=0; k<$WIN_SIZE; k++ ))
 do
	 TMP="$TMP$(($3 + $k + $2)) $(($3 + $k))."
   row=$(($3 + $k + $2 + 1))
   if [ $row == $1 ]
   then
     row=0
   fi
   if [ $(($k+1)) != $WIN_SIZE ]
   then
	   TMP="${TMP}$row $(($3 + $k))."
   fi
 done
 TMP=`echo $TMP | sed 's/\.$//g'`
 echo $TMP
}
function moveColumn {
 TMP="$1.3.1."
 WIN_SIZE=3
 #ruch X i O
 for (( k=0; k<$WIN_SIZE; k++ ))
 do
	 TMP="$TMP$(($3 + $k)) $(($3 + $k + $2))."
   row=$(($3 + $k + $2 + 1))
   if [ $row == $1 ]
   then
     row=0
   fi
   if [ $(($k+1)) != $WIN_SIZE ]
   then
	   TMP="${TMP}$row $(($3 + $k + $2))."
   fi
 done
 TMP=`echo $TMP | sed 's/\.$//g'`
 echo $TMP
}
function hor {
  #ilosc wierszy
  for (( i = 0; i<$1; i++ ))
  do
    WIN_ROW=$(($1 - 3 + 1 - i))
    if [ $WIN_ROW > 0 ]
    then
    #ilosc wygranych w row
    for (( z = 0; z<$WIN_ROW; z++ ))
    do
      move $1 $i $z
    done
    else
      break
     fi
  done
  #ilosc kolumn
  for (( i = 1; i<$1; i++ ))
  do
    WIN_COLUMN=$(($1 - 3 + 1 - i))
    if [ $WIN_COLUMN > 0 ]
    then
    #ilosc wygranych w row
    for (( z = 0; z<$WIN_COLUMN; z++ ))
    do
      moveColumn $1 $i $z
    done
    else
      break
     fi
  done
}

#rozmiar planszy
for (( i=3; i<=$BOARD_MAX; i++ ))
do
  #echo "Rozmiar planszy: $i"
  hor $i
done

