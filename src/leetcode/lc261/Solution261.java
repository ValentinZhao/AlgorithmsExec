package lc261;

import java.util.ArrayList;
import java.util.List;

/**
 * 由题意我们分析出来本题就是判断图有没有成环，成环的判断法则有二：一个是在dfs的过程中的下个节点本身未被访问过，同时以它为起点的dfs检查亦不成环
 * 第二个是下个节点，也就是neighbor被访问过，但是它的上个节点并非是通过递归调用向下传递的父节点，这就意味着当前被遍历节点还有一条分支连到上面成环
 * 这才能做到说之前被访问过，同时又不是本次递归访问到的情况
 *
 *
 * 那么树的定义是，一个没有成环的无向连接图，那么检查就分两步，一个是检查是否有环，一个是检查是否都连接，那么后者可以用dfs的visited列表来检查
 * 如果都跑完一遍发现还是有节点没有被遍历到，说明它是游离的，此时不成树
 */
public class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(graph, 0, visited, -1)) return false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int curr, boolean[] visited, int parent) {
        visited[curr] = true;
        for (int i = 0; i < graph.get(curr).size(); i++) {
            int neighbor = graph.get(curr).get(i);
            // 避免self-loop，访问过了并且parent也是自己
            if ((visited[neighbor] && parent != neighbor) ||
                    (!visited[neighbor] && hasCycle(graph, neighbor, visited, curr))) {
                return true;
            }
        }
        return false;
    }
}
