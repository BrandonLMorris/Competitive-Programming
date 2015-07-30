#Finding The Score
#HackerRank Pythonista Contest
#Created by Brandon Morris 11/1/14

import xml.etree.ElementTree as etree

number = int(input())
xml = ""
for i in range(number):
	xml += input()

tree = etree.ElementTree(etree.fromstring(xml))
root = tree.getroot()



counter = len(root.attrib)
for x in tree.findall(".//"):
	counter += len(x.attrib)

print(counter)