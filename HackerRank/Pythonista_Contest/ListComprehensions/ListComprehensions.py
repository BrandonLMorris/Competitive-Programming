#List Comprehensions
#HackerRank Pythonista Contest
#Created by Brandon Morris 11/1/14

x = int(input())
y = int(input())
z = int(input())

n = int(input())
outList = []

for _x in range(x+1):
	for _y in range(y+1):
		for _z in range(z+1):
			if _x + _y + _z != n:
				outList.append([_x, _y, _z])

print(outList);