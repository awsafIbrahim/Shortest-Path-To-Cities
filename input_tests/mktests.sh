#!/bin/sh

TESTS='00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19'
# TESTS='00 01 02 03 04 05 06 07 08 09'

for i in $TESTS; do 
  echo Generating test $i
  java RouteCost < test.$i.in > test.$i.gold
  cat test.$i.in
  echo ------------------
  cat test.$i.gold
  echo ==================
done
