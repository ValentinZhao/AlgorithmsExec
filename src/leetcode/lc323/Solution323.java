package lc323;

import java.util.*;

/**
 * 有一个非常巧妙分island的方式就是使用set，然后我们在dfs的过程中不断加入set，然后再从上面dfs的时候如果遍历过就跳过，没遍历过就n++
 */
public class Solution323 {
    public int countComponents(int n, int[][] edges) {
        if (n < 2) return n;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                // 那么重点就在于，dfs的过程中把属于一个island的所有点都遍历，并且塞入了set中
                // 那么之后再遍历到该点就不会再dfs也不会增长count了
                readDFS(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    private void readDFS(Map<Integer, List<Integer>> graph, int i, Set<Integer> visited) {
        for (int j : graph.get(i)) {
            if (visited.add(j))
                readDFS(graph, j, visited);
        }
    }
}
