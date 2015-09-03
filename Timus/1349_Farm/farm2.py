# Alternate solution to 1349
# Only two possible solutions: 1 2 3 for n = 1 and 3 4 5 for n = 2
# All others are -1

n = int(input())
if (n == 1):
    print("1 2 3")
elif (n == 2):
    print("3 4 5")
else:
    print("-1")
