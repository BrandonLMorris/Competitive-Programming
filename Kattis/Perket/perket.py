#!/usr/bin/env python3
"""
Solution to Kattis problem Perket

Created by Brandon Morris on May 1, 2016
"""


def gen_bin_string(n):
    current = 0
    while current < pow(2, n) - 1:
        current += 1
        yield ('0' * n + bin(current)[2:])[-n:]


def flavor_diff(bin_str, sour_bitter):
    sour, bitter = 1, 0
    for i in range(len(bin_str)):
        if bin_str[i] == '1':
            sour *= sour_bitter[i][0]
            bitter += sour_bitter[i][1]
    return abs(sour - bitter)


if __name__ == '__main__':
    n = int(input())
    ingredients = list()
    for i in range(n):
        ingredients.append([int(e) for e in input().split()])

    print(min(
        [flavor_diff(s, ingredients) for s in gen_bin_string(n)]
    ))

