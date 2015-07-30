#!/bin/bash
for i in {1..99}
do
	if [ -neq $((i % 2)) 0 ]
	then
		echo $i
	fi
done