#!/bin/bash
TYPE=${1:-"horizontal"}

if [ $TYPE == "horizontal" ] || [ $TYPE == "0" ]
then
./expect.sh "3.3.1.0 0.1 1.0 1.2 0.0 2"
./expect.sh "3.3.1.1 0.2 2.1 1.0 0.1 2"
./expect.sh "3.3.1.2 0.0 2.2 1.0 0.2 2"
fi

if [ $TYPE == "vertical" ] || [ $TYPE == "1" ]
then
./expect.sh "3.3.1.0 0.1 1.1 0.0 2.2 0"
./expect.sh "3.3.1.0 1.0 2.1 1.0 0.2 1"
./expect.sh "3.3.1.0 2.0 1.1 2.0 0.2 2"
fi

if [ $TYPE == "diagonal" ] || [ $TYPE == "2" ]
then
./expect.sh "3.3.1.0 0.0 1.1 1.0 2.2 2"
fi

if [ $TYPE == "rdiagonal" ] || [ $TYPE == "3" ]
then
./expect.sh "3.3.1.0 2.0 1.1 1.0 0.2 0"
fi
