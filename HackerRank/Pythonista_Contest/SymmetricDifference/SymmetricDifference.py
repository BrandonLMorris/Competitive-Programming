#Symmetric Difference
#HackerRank Pythonista Contest
#Created by Brandon Morris 11/1/2014

num1 = input()
set1 = {x for x in input().split()}
num2 = input()
set2 = {y for y in input().split()}

outList = []
for x in set1 ^ set2:
	outList.append(int(x))


outList.sort()

for i in outList:
	print(i)