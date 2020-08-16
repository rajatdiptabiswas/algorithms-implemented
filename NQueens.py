#!/usr/bin/env python3


def print_grid(grid):
    """Print the grid in the desired format."""
    n = len(grid)
    print()
    for y in range(n):
        for x in range(n):
            if grid[y][x]:
                print('x', end=' ')
            else:
                print('·', end=' ')
        print()


def in_grid(x, y, grid):
    """Check if the indices are in the limits of the n x n grid."""
    return 0 <= x < len(grid) and 0 <= y < len(grid)


def is_safe(x, y, grid):
    """
    Check if it is safe to place the Queen in the x, y position.

    The function checks whether the
    top-left diagonal or
    top-right diagonal or
    top-vertical line
    has any Queens in them.
    """
    for i in range(1, y + 1):
        if in_grid(x - i, y - i, grid) and grid[y - i][x - i] or \
           in_grid(x + i, y - i, grid) and grid[y - i][x + i] or \
           in_grid(x, y - i, grid) and grid[y - i][x]:
            return False
    return True


def n_queens(grid, y=0):
    """Solve the N-Queens problem."""
    n = len(grid)

    if y == n:
        print_grid(grid)
        return

    for x in range(n):
        if is_safe(x, y, grid):
            grid[y][x] = True
            n_queens(grid, y + 1)
            grid[y][x] = False
    return


def main():
    """
    Main function.

    Asks for n as input.
    """
    n = int(input('n = '))
    grid = [[False for i in range(n)] for j in range(n)]
    n_queens(grid)


if __name__ == '__main__':
    main()
