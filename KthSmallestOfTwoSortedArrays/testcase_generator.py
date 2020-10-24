#!/usr/bin/env python3

from random import randint

N_MIN = 1
N_MAX = 10

M_MIN = 1
M_MAX = 10

VAL_MIN = 0
VAL_MAX = 100


def main():
    n = randint(N_MIN, N_MAX)
    a = [randint(VAL_MIN, VAL_MAX) for _ in range(n)]
    a.sort()

    m = randint(M_MIN, M_MAX)
    b = [randint(VAL_MIN, VAL_MAX) for _ in range(m)]
    b.sort()

    print(*a)
    print(*b)

    k = randint(1, n+m)

    print(k)


if __name__ == '__main__':
    main()
