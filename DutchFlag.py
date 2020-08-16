#!/usr/bin/env python3


"""
Dutch national flag problem.

Given a number of red, blue and white balls in random order,
arrange them in the order of the colours in the Dutch national flag.

0 -> red
1 -> white
2 -> blue

input
random permutation of 0, 1, and 2
[ 1 0 2 0 2 1 ... 2 1 1 2 0 0 ]

output
sorted array
[ 0 0 ... 0 1 1 ... 1 2 2 ... 2 ]
"""


def dutch_flag(arr):
    n = len(arr)

    lo = 0
    mid = 0
    hi = n - 1

    while mid < hi:
        if arr[mid] == 0:
            arr[mid], arr[lo] = arr[lo], arr[mid]
            lo += 1
            mid += 1
        elif arr[mid] == 1:
            mid += 1
        elif arr[mid] == 2:
            arr[mid], arr[hi] = arr[hi], arr[mid]
            hi -= 1
        else:
            raise ValueError('invalid input')

    return arr


def main():
    print('Enter space separated permutation of 0, 1, and 2:')
    a = [int(x) for x in input().split()]

    print(dutch_flag(a))


if __name__ == '__main__':
    main()
