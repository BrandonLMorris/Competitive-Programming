"""
Given a series of gear sizes, find the ratios with which each gear will turn
in respect to the first.
"""
from fractions import gcd

num = input()
lst = [int(e) for e in input().split()]

first = lst.pop(0)
for second in lst:
    factor = gcd(first, second)
    print(str(first//factor) + '/' + str(second//factor))
