one = 1
two = 2

sum = 0
fibs = [two]

while (True):
    temp = two
    two = one + two
    if (two > 4000000): break
    one = temp
    if (two % 2 == 0):
        fibs.append(two)
    #sum += two

for i in fibs:
    sum += i
    print(i)

print(sum)
