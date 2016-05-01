#!/usr/bin/env python3
"""
Solution to Kattis problem Kolone

Created by Brandon Morris on May 1, 2016
"""

if __name__ == '__main__':
    n1, n2 = [int(e) for e in input().split()]
    l1 = input()[::-1]
    l2 = input()

    result = ''
    displacement = int(input())
    l1_pos, l2_pos = 0, 0

    for i in range(displacement - len(l1)):
        result += l2[l2_pos]
        l2_pos += 1
        if l2_pos >= len(l2): break

    for i in range(len(l1) - displacement):
        result += l1[l1_pos]
        l1_pos += 1
        if l1_pos >= len(l1): break

    while l2_pos < len(l2):
        result += l2[l2_pos]
        l2_pos += 1
        if l1_pos < len(l1):
            result += l1[l1_pos]
            l1_pos += 1

    while l1_pos < len(l1):
        result += l1[l1_pos]
        l1_pos += 1

    print(result)
