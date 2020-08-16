#!/usr/bin/env python3


def bfs(src, dst, graph):
    queue = []
    queue.append(src)

    dist = {
        key: 0 for key in graph.keys()
    }
    pred = {
        key: 0 for key in graph.keys()
    }
    visited = set()

    while queue:
        curr = queue.pop(0)
        if curr not in visited:
            if curr == dst:
                path = []
                crawl = dst
                while crawl != 0:
                    path.insert(0, crawl)
                    crawl = pred[crawl]
                print(f'The path from {src} -> {dst} is {path}')
                print(f'The destination is {dist[dst]} steps away from source')
                return True
            else:
                visited.add(src)
                for i in graph[curr]:
                    dist[i] = dist[curr] + 1
                    pred[i] = curr
                    queue.append(i)

    print(f'No path exists')
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

    src = input('source      -> ')
    dst = input('destination -> ')

    bfs(src, dst, graph)


if __name__ == '__main__':
    main()