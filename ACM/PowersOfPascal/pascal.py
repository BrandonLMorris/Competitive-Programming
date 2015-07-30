import math;

def choose(n,k):
    return math.factorial(n)/(math.factorial(k)*math.factorial(n-k))

def pascal(p, r, c):
    return math.pow(p, r-c) * choose(r,c)

numTests = int(raw_input());
for i in range(1, numTests+1):
    test, p, r, c = [int(e) for e in raw_input().split()]
    s = str(test) + " " + str(int(pascal(p, r, c)))
    print s
