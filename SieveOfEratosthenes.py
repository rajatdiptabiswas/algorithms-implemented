#!/usr/bin/env python3

import math
from functools import reduce


def sieve(n):
    all_nums = set(range(2, n))
    to_check = range(2, math.ceil(n**0.5))

    for x in to_check:
        if x in all_nums:
            all_nums -= set(range(x**2, n, x))
    
    return all_nums


sieve_one_liner = lambda n: reduce(lambda all_nums, x: all_nums - set(range(x**2, n, x)) if x in all_nums else all_nums, range(2, math.ceil(n**0.5)), set(range(2, n)))


def main():
    print(sieve(100))
    print(sieve_one_liner(100))


if __name__ == '__main__':
    main()
