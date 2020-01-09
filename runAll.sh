#!/bin/bash
SIZE=${1:-4}
./script.sh $SIZE > cmd.txt
IFS=$'\n'
echo "" > horizontal.txt

for cmd in $(./script.sh $SIZE)
do
	./expect.sh "$cmd" >> horizontal.txt
	echo .
	echo "" >> horizontal.txt
	echo "____________________" >> horizontal.txt
done
