package lc886;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 无向图染色/无向图二分经典模板题，非常重要
 */
public class Solution886 {
    private ArrayList<Integer>[] graph;
    private Map<Integer, Integer> color;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        color = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (!color.containsKey(i) && !dyeDFS(i, 0)) {
                return false;
            }
        }
        return true;
    }

    // we choose to dye all nodes with 2 colors: 0 or 1.
    // so the param dyedColor is always 0 or 1, and we use XOR to simplify the toggle
    private boolean dyeDFS(int node, int dyedColor) {
        if (color.containsKey(node)) return color.get(node) == dyedColor;
        color.put(node, dyedColor);
        for (int neighbor : graph[node]) {
            if (!dyeDFS(neighbor, dyedColor ^ 1)) return false;
        }
        return true;
    }
}
