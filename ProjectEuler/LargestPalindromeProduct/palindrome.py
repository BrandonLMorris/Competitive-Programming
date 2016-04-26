lst = list()
for i in range(100, 1000):
    for j in range(i, 1000):
        s = str(j * i)
        if s == s[::-1]: lst.append(int(s))

print(max(lst))
