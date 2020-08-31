class UnionFind {

    private int[] parent;
    private int[] size;
    private int components;

    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        components = n;
        for (int x = 0; x < n; x++) {
            parent[x] = x;
            size[x] = 1;
        }
    }

    private int find(int p) {
        if (p == parent[p]) {
            return p;
        }
        return parent[p] = find(parent[p]);
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (size[rootP] <= size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        components -= 1;
    }

    public int components() {
        return components;
    }

}