#!/usr/bin/env python3


"""
Flood Fill Algorithm.

Given a 2D screen, location of a pixel in the screen and a color, replace
color of the given pixel and all adjacent same colored pixels with the
given color.


Example:

Input:
    screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 0},
                    {1, 0, 0, 1, 1, 0, 1, 1},
                    {1, 2, 2, 2, 2, 0, 1, 0},
                    {1, 1, 1, 2, 2, 0, 1, 0},
                    {1, 1, 1, 2, 2, 2, 2, 0},
                    {1, 1, 1, 1, 1, 2, 1, 1},
                    {1, 1, 1, 1, 1, 2, 2, 1},
                    };
    x = 4, y = 4, newColor = 3

The values in the given 2D screen indicate colors of the pixels.

x and y are coordinates of the brush, newColor is the color that should
replace the previous color on screen[x][y] and all surrounding pixels
with same color.

Output:
Screen should be changed to following.
    screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 0},
                    {1, 0, 0, 1, 1, 0, 1, 1},
                    {1, 3, 3, 3, 3, 0, 1, 0},
                    {1, 1, 1, 3, 3, 0, 1, 0},
                    {1, 1, 1, 3, 3, 3, 3, 0},
                    {1, 1, 1, 1, 1, 3, 1, 1},
                    {1, 1, 1, 1, 1, 3, 3, 1},
                    };
"""


def flood_fill(x, y, prev_color, new_color, screen):
    def is_safe(x, y, grid):
        return 0 <= x < len(grid[0]) and 0 <= y < len(grid)

    x_dir = [-1, 0, 1, 0]
    y_dir = [0, 1, 0, -1]

    screen[y][x] = new_color

    for i in range(4):
        new_x = x + x_dir[i]
        new_y = y + y_dir[i]

        if is_safe(new_x, new_y, screen) and \
           screen[new_y][new_x] == prev_color:
            flood_fill(new_x, new_y, prev_color, new_color, screen)


def main():
    grid = [[1, 1, 1, 1, 1, 1, 1, 1],
            [1, 1, 1, 1, 1, 1, 0, 0],
            [1, 0, 0, 1, 1, 0, 1, 1],
            [1, 2, 2, 2, 2, 0, 1, 0],
            [1, 1, 1, 2, 2, 0, 1, 0],
            [1, 1, 1, 2, 2, 2, 2, 0],
            [1, 1, 1, 1, 1, 2, 1, 1],
            [1, 1, 1, 1, 1, 2, 2, 1]]

    x = 4
    y = 4
    prev_color = grid[4][4]
    new_color = 3

    flood_fill(x, y, prev_color, new_color, grid)

    for g in grid:
        print(*g)


if __name__ == '__main__':
    main()