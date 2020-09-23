#!/usr/bin/env python3


def permuation_helper(array, lo, hi):
    if lo == hi:
        print(array)
        return
    for i in range(lo, hi + 1):
        array[lo], array[i] = array[i], array[lo]
        permuation_helper(array, lo + 1, hi)
        array[lo], array[i] = array[i], array[lo]


def permutation(array):
    permuation_helper(array, 0, len(array)-1)


def main():
    a = [1,2,3,4]
    permutation(a)


if __name__ == '__main__':
    main()
