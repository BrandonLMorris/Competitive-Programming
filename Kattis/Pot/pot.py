#!/usr/bin/env python3
"""Solution to Kattis problem Pot"""
import math

def get_num_power(x):
    return math.pow(int(x[:-1]), int(x[-1]))

if __name__ == '__main__':
    num_numbers = int(input())
    print(int(sum([get_num_power(input()) for i in range(num_numbers)])))


