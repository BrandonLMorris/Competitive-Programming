#!/usr/bin/env python3
"""Solution to the Kattis problem Pizza Crust"""
import math

def pizza_area(rad):
    return math.pi * (rad * rad)

if __name__ == '__main__':
    vals = input().split()
    pizza_radius, cheese_radius = int(vals[0]), int(vals[0]) - int(vals[1])

    if cheese_radius == 0:      # It's inadvisable to divide by zero
        ratio = 0
    else:
        ratio = pizza_area(cheese_radius) / pizza_area(pizza_radius)

    print(ratio * 100)

