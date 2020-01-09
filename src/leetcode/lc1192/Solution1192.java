package lc1192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * low[u] records the lowest vertex u can reach
 * The value low[v] indicates earliest visited vertex reachable from subtree rooted with v.
 * The condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]”.
 *
 * disc[u] records the time when u was discovered（这个time不是次数，就是发现时的时间，我们用"步数"来表示这种时间）
 */
public class Solution1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n], disc = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc , -1);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> edge = connections.get(i);
            int from = edge.get(0), to = edge.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }

        return res;
    }

    int time = 0;
    private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int parent) {
        low[u] = disc[u] = ++time;
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == parent) {
                continue; // if parent vertex, ignore
            }
            if (disc[v] == -1) { // if not discovered
                dfs(v, low, disc, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(u, v));
                }
            } else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
