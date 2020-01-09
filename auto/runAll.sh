#!/bin/bash
SIZE=${1:-4}
IFS=$'\n'
echo "" > results/reverseSlunt.txt
for cmd in $(./createHorizontal.sh $SIZE)
do
	./expect.sh "$cmd" >> results/horizontal.txt
	echo .
	echo "" > results/horizontal.txt
done
for cmd in $(./createVertical.sh $SIZE)
do
	./expect.sh "$cmd" >> results/vertical.txt
	echo .
	echo "" >> results/vertical.txt
done
for cmd in $(./createSlant.sh $SIZE)
do
	./expect.sh "$cmd" >> results/slant.txt
	echo .
	echo "" >> results/slant.txt
done
for cmd in $(./createRSlant.sh $SIZE)
do
	./expect.sh "$cmd" >> results/reverseSlant.txt
	echo .
	echo "" >> results/reverseSlant.txt
done

#draw
