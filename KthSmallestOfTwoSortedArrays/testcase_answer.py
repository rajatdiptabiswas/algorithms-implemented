#!/usr/bin/env python3


def main():
    a = [int(x) for x in input().split()]
    b = [int(y) for y in input().split()]
    k = int(input())

    sorted_array_union = sorted(a+b)

    # print(a)
    # print(b)
    # print(k)
    # print(sorted_array_union)

    # print(*sorted_array_union, sep='\n')
    print(sorted_array_union[k-1])


if __name__ == '__main__':
    main()