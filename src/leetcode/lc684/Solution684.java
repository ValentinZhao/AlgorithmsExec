package lc684;

public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] sets = new int[edges.length + 1];
        for (int[] edge : edges) {
            int u = find(edge[0], sets);
            int v = find(edge[1], sets);
            if (u == v) // 在相同连通分量中，则当前边是多余的
                return edge;
            sets[u] = v;
        }
        return new int[]{};
    }

    private int find(int s, int[] sets) {
        if (sets[s] == 0) return s;
        sets[s] = find(sets[s], sets); // add path compression here
        return sets[s];
    }
}

// 下面是经典的并查集(Disjoint Set)写法，包含了path compression和union by rank

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet set = new DisjointSet(edges.length);
        for (int[] edge : edges) {
            // 减一的逻辑在下面的构造函数中解释了
            if (!set.union(edge[0]-1, edge[1]-1)) return edge;
        }
        throw new IllegalArgumentException();
    }

    static class DisjointSet {
        private int[] rank;
        private int[] parent;

        public DisjointSet(int n) {
            // 因为这边我们初始化给了n-1个位置，那么在上面union的时候才把所有的node值减掉了1
            rank = new int[n];
            parent = new int[n];
        }

        public int find(int v, int[] sets) {
            if (sets[v] == 0) return v; // 当连通分量root集合中并未找到该点的root时，就认为root是它自己
            sets[v] = find(sets[v], sets); // path compression
            return sets[v];
        }

        public boolean union(int x, int y) {
            int rootX = find(x, parent);
            int rootY = find(y, parent);
            if (rootX == rootY) return false; // 在同一个连通分量中，此条边多余
            // 低rank的root把指针指向高的
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
    }
}