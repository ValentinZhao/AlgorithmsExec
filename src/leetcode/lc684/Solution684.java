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

        /**
         * 寻找祖先时采用递归，但是一旦元素一多起来，或退化成一条链，每次GetFather都将会使用O（n）的复杂度，这显然不是我们想要的。
         * 对此，我们必须要进行路径压缩，即我们找到最久远的祖先时“顺便”把它的子孙直接连接到它上面。这就是路径压缩了。
         */
        public int find(int v, int[] sets) {
            if (sets[v] == 0) return v; // 当连通分量root集合中并未找到该点的root时，就认为root是它自己
            sets[v] = find(sets[v], sets); // path compression，理解就是find最后一定会返回root值，那么这个时候就把sets[v]的root值直接给到了真正的root，不就压缩了么
            return sets[v];
        }

        /**
         * 该方法使用秩来表示树高度的上界，在合并时，总是将具有较小秩的树根指向具有较大秩的树根。
         * 简单的说，就是总是将比较矮的树作为子树，添加到较高的树中。为了保存秩，需要额外使用一个与 uset 同长度的数组，并将所有元素都初始化为 0。
         * 这样找祖先会减少递归迭代的次数，最坏只有logN次。
         */
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