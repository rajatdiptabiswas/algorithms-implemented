#!/bin/bash

for (( i=1; ; i++ ))
do
    echo "$i"
    # javac KthSmallestOfTwoSortedArrays.java
    python3 testcase_generator.py > in.txt
    java KthSmallestOfTwoSortedArrays < in.txt > out1.txt
    python3 testcase_answer.py < in.txt > out2.txt
    diff -w out1.txt out2.txt || break
done