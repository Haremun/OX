#!/bin/bash
SIZE=${1:-4}
IFS=$'\n'
echo "" > horizontal.txt

for cmd in $(./createHorizontal.sh $SIZE)
do
	./expect.sh "$cmd" >> horizontal.txt
	echo .
	echo "" >> horizontal.txt
	echo "____________________" >> horizontal.txt
done
for cmd in $(./createVertical.sh $SIZE)
do
	./expect.sh "$cmd" >> vertical.txt
	echo .
	echo "" >> vertical.txt
	echo "____________________" >> vertical.txt
done
