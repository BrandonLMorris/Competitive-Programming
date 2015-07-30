#Regex 1 - Validating the phone number
#HackeRank Pythonista Contest
#Created by Brandon Morris 1/11/2014

import re

x = int(input())

for i in range(x):
	phoneNum = input()
	match = re.search(r"^[7-9]\d\d\d\d\d\d\d\d\d$", phoneNum)
	if match:
		print("YES")
	else:
		print("NO")
