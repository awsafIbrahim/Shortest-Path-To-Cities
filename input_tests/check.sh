#!/bin/sh

PREFIX=test
TESTS='00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19'
PROG=RouteCheck

javac $PROG.java 
if [ $? -eq 0 ]; then 
  for T in $TESTS; do
    if [ -f $PREFIX.$T.in ]; then  
      echo ===========================================
      echo Test file: $PREFIX.$T.in 
      java $PROG < $PREFIX.$T.in 
    else
      echo Oops: file $PREFIX.$T.in does not exist!
    fi
  done
fi
