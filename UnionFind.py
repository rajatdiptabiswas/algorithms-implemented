class UnionFind:
    def __init__(self, n: int) -> None:
        self.parent = [i for i in range(n)]
        self.size = [1 for _ in range(n)]
        self.count = n

    def find(self, p: int) -> int:
        while p != self.parent[p]:
            p = self.parent[self.parent[p]]
        return p

    def union(self, p: int, q: int) -> None:
        root_p = self.find(p)
        root_q = self.find(q)

        if root_p == root_q:
            return

        if self.size[root_p] <= self.size[root_q]:
            self.parent[root_p] = root_q
            self.size[root_q] += self.size[root_p]
        else:
            self.parent[root_q] = root_p
            self.size[root_p] += self.size[root_q]

        self.count -= 1

    def connected(self, p: int, q: int) -> bool:
        return self.find(p) == self.find(q)

    def components(self) -> int:
        return self.count
