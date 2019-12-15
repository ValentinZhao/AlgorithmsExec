package lc547;

/**
 * 这题的话，每行每列其实都是一个人，而不是每个节点是一个人，M[i][i]就是指代某人自己，M[i][j]就是指代某人和其他人的关系
 * visited只记录一行（其实也可以说是一列）是否被访问，它其实就是记录某人是否被访问到，增加访问记录的条件就是，这个人从未被访问过并且是朋友关系
 */
public class Solution547 {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] != 1) {
                visited[i] = 1;
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                // 到了新的一行发现这个人也是朋友但是还没遍历到，给上1
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}

// union-find 简洁写法
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind un = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    un.union(i, j);
                }
            }
        }

        return un.getCount();
    }

    class UnionFind {

        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI == rootJ) return;

            count--;
            parent[rootI] = rootJ;
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
                i = parent[i];
            }

            return parent[i];
        }

        public int getCount() {
            return this.count;
        }
    }
}
