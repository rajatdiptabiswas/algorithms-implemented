#!/usr/bin/env python3


"""
Find all k combinations in lexographical order.

Input:
'abcde' 3

Output:
abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde

Explanation:
For an input of length 5, there will be 
5!/(3! * 2!) = 10 outputs.
"""


def get_combinations(string, remaining, index=0, current_str=''):
    if remaining > len(string) - index:
        return

    if remaining == 0:
        print(current_str)
        return

    for i in range(index, len(string)):
        get_combinations(string, remaining - 1, i + 1, current_str + string[i])


def main():
    get_combinations('abcde', 3)


if __name__ == '__main__':
    main()