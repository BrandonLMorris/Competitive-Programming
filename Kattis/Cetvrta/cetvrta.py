#!/usr/bin/env python3
"""
Solution to the Kattis problem "Cetvrta"
"""

if __name__ == '__main__':
    points = list()
    for i in range(3):
        points.append([int(e) for e in input().split()])

    x_result = points[0][0] ^ points[1][0] ^ points[2][0]
    y_result = points[0][1] ^ points[1][1] ^ points[2][1]
    print(x_result, y_result)
