#!/usr/bin/env python3


def bfs(graph, key):
    queue = []
    queue.append('A')

    visited = set()

    while queue:
        print(queue)
        current_node = queue.pop(0)

        if current_node not in visited:
            if current_node == key:
                print(f'Found {key}')
                return True
            else:
                queue += graph[current_node]
                visited.add(current_node)

    print(f'Could not find {key} in graph')
    return False


def main():
    graph = {
        'A': ['B', 'C', 'D', 'E'],
        'B': ['U', 'V'],
        'C': ['O', 'P'],
        'D': ['K', 'L'],
        'E': ['F', 'G', 'H'],
        'F': ['Y', 'Z'],
        'G': ['I'],
        'H': [],
        'I': ['J'],
        'J': [],
        'K': ['M', 'N'],
        'L': [],
        'M': [],
        'N': [],
        'O': ['R', 'Q'],
        'P': ['S', 'T'],
        'Q': [],
        'R': [],
        'S': [],
        'T': [],
        'U': ['W'],
        'V': ['X'],
        'W': [],
        'X': [],
        'Y': [],
        'Z': [],
    }

    key = input('Enter node to find: ')
    bfs(graph, key)


if __name__ == '__main__':
    main()
