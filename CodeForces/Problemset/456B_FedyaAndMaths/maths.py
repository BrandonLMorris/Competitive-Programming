#!/usr/bin/python

# CodeForces Problem 456B
# Using Python since it's expanding inteer type helpful for this problem

# Given a number n, find (1^n + 2^n + 3^n + 4^n) mod 5

# Efficient modular exponentiation using right-to-left binary method
# as described in https:/en.wikipedia.org/wiki/Modular_exponentiation
def exp_mod(base, exponent, modulus):
    result = 1
    base = base % modulus
    while exponent > 0:
        if exponent % 2 == 1:
            result = (result * base) % modulus
        exponent = exponent >> 1
        base = pow(base, 2) % modulus
    return result

if __name__ == "__main__":
    exponent = int(input())

    exponent = exponent % 4

    result = pow(1, exponent) + pow(2, exponent) + pow(3, exponent) + \
            pow(4, exponent)
    result = result % 5

    print(result)
