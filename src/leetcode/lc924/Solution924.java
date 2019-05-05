package lc924;

import java.util.Arrays;

/**
 * 考察并查集（Disjoint-Set）
 * 题目让返回多个连通分量中，去掉其中的某个initial感染点能够获得最大免感染量的index
 * 那么这题我们通过Union-Find的方法来做，intuition就是各个相连，然后记录下来每个分量的size，找最大的分量感染点为1的那个返回index
 */
public class Solution924 {
    private int[] parent;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] malwareCount = new int[n];
        int[] sizes = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) union(i, j);
            }
        }
        for (int i = 0; i < n; i++) sizes[find(i)]++;
        for (int init : initial) malwareCount[find(init)]++;
        int res = -1;
        int maxSize = 0;
        Arrays.sort(initial);
        for (int init : initial) {
            int index = find(init);
            if (sizes[index] > maxSize && malwareCount[index] == 1) {
                maxSize = sizes[index];
                res = init;
            }
        }
        return maxSize == 0 ? initial[0] : res;
    }

    /**
     * 路径压缩
     */
    private int find(int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    /**
     * 在这里我们把j的最顶部的根放到i的根的下面，完成join
     */
    private void union(int i, int j) {
        parent[find(i)] = find(j);
    }
}
