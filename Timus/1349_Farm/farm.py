def main():
    n = int(input())
    if (n == 0 or n > 2):
        print(-1)
        return

    for i in range(1, 101):
        for j in range(1, 101):
            if (j == i):
                continue
            for k in range(1, 101):
                if (k == i or k == j):
                    continue
                if (pow(i, n) + pow(j, n) == pow(k, n)):
                    print(str(i) + " " + str(j) + " " + str(k))
                    return

main()
