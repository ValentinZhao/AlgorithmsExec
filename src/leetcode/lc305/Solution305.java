package lc305;

import java.util.ArrayList;
import java.util.List;

public class Solution305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        //
        DisjointSet set = new DisjointSet(m*n);
        List<Integer> answer = new ArrayList<>();
        for (int[] position : positions) {
            List<Integer> overlap = new ArrayList<>();
            int r = position[0], c = position[1];

            // 接下来从当前点检查四个方向的点，如果有点是在某个连通分量上的，就先记下来这个点（m * n矩阵上某个点的位置我们采用r * n + c的方式来记录，表示高x高度+宽度）
            if (r - 1 >= 0 && set.isValid((r - 1) * n + c)) overlap.add((r - 1) * n + c);
            if (r + 1 < m && set.isValid((r+1) * n + c)) overlap.add((r+1) * n + c);
            if (c - 1 >= 0 && set.isValid(r * n + c - 1)) overlap.add(r * n + c - 1);
            if (c + 1 < n && set.isValid(r * n + c + 1)) overlap.add(r * n + c + 1);

            int currentIndex = r * n + c;
            set.setParent(currentIndex);
            // 如果四周有位置在其他岛上，我们尝试看看当前这个点是否也能合到那些岛上
            for (int pos : overlap) set.union(pos, currentIndex);
            answer.add(set.getCount());
        }
        return answer;
    }

    static class DisjointSet {
        private int[] parents;
        private int[] rank;
        private int count;

        public DisjointSet(int n) {
            parents = new int[n];
            rank = new int[n];
            count = 0;
            for (int i = 0; i < n; i++) {
                parents[i] = -1;
                rank[i] = 0;
            }
        }

        public int find(int v) {
            if (parents[v] != v) parents[v] = find(parents[v]);
            return parents[v];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) parents[rootX] = rootY;
                else if (rank[rootX] > rank[rootY]) parents[rootY] = rootX;
                else {
                    rank[rootX] = rootY;
                    rank[rootY]++;
                }
                count--;
            }
        }
        // 用于判断当前点是否已经存在与某个连通分量内（即是否已经在某个岛上）
        public boolean isValid(int p) {
            return parents[p] >= 0;
        }
        // 用于外部找到一个新的分离岛时，手动设置root并增加计数
        public void setParent(int p) {
            parents[p] = p;
            count++;
        }
        public int getCount() {
            return count;
        }
    }
}
