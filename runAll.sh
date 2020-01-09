#!/bin/bash
SIZE=${1:-4}
IFS=$'\n'
echo "" > results/horizontal.txt

for cmd in $(./createHorizontal.sh $SIZE)
do
	./expect.sh "$cmd" >> results/horizontal.txt
	echo .
	echo "" >> results/horizontal.txt
	echo "____________________" >> results/horizontal.txt
done

for cmd in $(./createVertical.sh $SIZE)
do
	./expect.sh "$cmd" >> results/vertical.txt
	echo .
	echo "" >> results/vertical.txt
	echo "____________________" >> results/vertical.txt
done
