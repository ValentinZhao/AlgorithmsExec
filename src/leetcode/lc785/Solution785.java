package lc785;

/**
 * 同leetcode 886，属于无向图着色问题
 */
public class Solution785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {

            // 亮点在于，未着色用0，已着色用1，-1
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        // 已经着色了
        if (colors[node] != 0) {
            // color是上个节点的颜色，colors[node]是现在这个节点的颜色
            return colors[node] == color;
        }

        colors[node] = color;
        for (int neighbor : graph[node]) {
            // 给下个节点染不一样的颜色
            if (!validColor(graph, colors, -color, neighbor)) {
                return false;
            }
        }
        return true;
    }


}