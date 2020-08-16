#!/usr/bin/env python3


"""
Find all combinations of k-bit numbers with n bits set
where 1 <= n <= k in sorted order.

Input:
k = 5

Output:
00001 00010 00100 01000 10000
00011 00101 00110 01001 01010 01100 10001 10010 10100 11000
00111 01011 01101 01110 10011 10101 10110 11001 11010 11100
01111 10111 11011 11101 11110
11111

Explanation:
DP[m][n] will consist of every m-bit number with n-bit set

Initialize DP[i][0] to '', '0', '00', '000', '0000', ...
To update DP[y][x] add 
Prefix '0' to DP[y-1][x] elements
Prefix '1' to DP[y-1][x-1] elements
We can add another 1 to DP[y-1][x-1] to make it DP[y][x]
"""


def k_bit_combinations(k):
    dp = [[[] for x in range(k+1)] for y in range(k+1)]
    string = ''

    for i in range(k+1):
        dp[i][0].append(string)
        string += '0'

    for y in range(1, k+1):
        for x in range(1, k+1):
            for s in dp[y-1][x]:
                dp[y][x].append('0' + s)
            for s in dp[y-1][x-1]:
                dp[y][x].append('1' + s)

    ans = []
    for i in range(k+1):
        for s in dp[k][i]:
            ans.append(s)

    for a in ans:
        print(a)


def main():
    k_bit_combinations(5)


if __name__ == "__main__":
    main()