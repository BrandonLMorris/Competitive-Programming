#Find a String
#HackerRank Pythonista Challenge
#Created by Brandon Morris 11/1/2014

counter = 0
longString = input()
searchString = input()

for i in range(len(longString)-len(searchString)+1):
	if(longString[i:len(searchString)+i] == searchString):
		counter += 1

print(counter)