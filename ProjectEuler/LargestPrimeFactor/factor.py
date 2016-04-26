from math import sqrt, ceil

def isPrime(x):
    if x % 2 == 0: return False
    curr = ceil(sqrt(x))
    # while curr > 1:

MAX = 1000000
is_prime = [True for i in range(MAX)]

for i in range(2, len(is_prime)):
    if not is_prime[i]: continue
    i += i
    while i < len(is_prime):
        is_prime[i] = False
        i += i

VAL = 600851475143
for i in range(ceil(sqrt(VAL)) + 10000, 0, -1):
    if is_prime[i] and VAL % i == 0:
        print(i)
        break
