import math


def choose(n, k):
    return math.factorial(n)/(math.factorial(k)*math.factorial(n-k))

def S(n, k):
    count = math.factorial(n)
    for t in range(1,k+1):
        count += math.factorial(n-t)*math.pow(-1,t)*choose(n,t)
        #print("intermediate: ",count)
    return int(count)

while(True):
    n, k = input().split()
    if (int(n) == 0): break
    s = S(int(n),int(k))
    print(s)

