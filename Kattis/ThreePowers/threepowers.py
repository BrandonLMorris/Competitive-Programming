#!/bin/env python3
"""
Solution to the Kattis Problem 'Three Powers'

Created by Lance Morris 2016
"""


if __name__ == '__main__':
    while True:
        x = int(input()) - 1
        if x == -1: break

        # Convert to binary and calculate the elements
        bin_str = bin(x)[2:][::-1]
        results = list()
        for i in range(len(bin_str)):
            if bin_str[i] == '1':
                results.append(pow(3, i))

        # Print the results
        if len(results) == 0:
            print('{ }')
        else:
            s = '{ ' + ', '.join(str(e) for e in results)
            s += ' }'
            print(s)

