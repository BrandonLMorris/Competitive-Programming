#Finding The Score
#HackerRank Pythonista Contest
#Created by Brandon Morris 11/1/14

import xml.etree.ElementTree as etree

maxDepth = 0

def findDepth(x, currentDepth):
	global maxDepth
	if len(x) > 0:
		#print(x)
		currentDepth = currentDepth + 1
		for i in x:
			findDepth(i, currentDepth)
	if currentDepth > maxDepth:
		maxDepth = currentDepth


number = int(input())
xml = ""
for j in range(number):
	xml += input()

tree = etree.ElementTree(etree.fromstring(xml))
root = tree.getroot()

findDepth(root, 0)
print(maxDepth)
