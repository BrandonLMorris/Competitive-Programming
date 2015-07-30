x = input()
set1 = set(list(map(int, input().split())))

y = input()
set2 = set(list(map(int, input().split())))

setDiff = set1.difference(set2)
setDiff.update(set2.difference(set1))
listDiff = list(setDiff)
listDiff.sort()
for i in range(len(listDiff)):
    print(listDiff[i])
