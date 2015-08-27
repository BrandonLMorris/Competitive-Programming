n, m, y = [int(e) for e in input().split()]

result = []
for i in range(m):
    if (pow(i, n, m) == y):
        result.append(i);

answer = ""
if len(result) == 0:
    print(-1)
else:
    for i in result:
        answer += str(i) + " "

print(answer)
