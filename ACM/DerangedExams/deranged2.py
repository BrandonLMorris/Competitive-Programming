import math

def S(n, k):
    #if (n == 0): return 0
    if (k == 0): return math.factorial(n)

    return S(n, k-1) - S(n-1, k-1)

x = int(input())
for i in range(1, x+1):
    t, n, k = raw_input().split()
    s = t + " " + str(int(S(int(n),int(k))))
    print s
