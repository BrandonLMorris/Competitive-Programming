#Regex2 - Validate a Roman Number
#HackerRank :: Pythonista Contest
#Created by Brandon Morris 11/3/2014

import re

numeral = input()

match = re.search(r"I{,3}V{,1}", numeral)
if match:
	print("True")
else:
	print("False")