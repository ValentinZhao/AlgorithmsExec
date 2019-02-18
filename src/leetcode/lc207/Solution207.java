package lc207;

import java.util.ArrayList;
import java.util.List;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequsite = prerequisites[i][1];
            graph.get(course).add(prerequsite);
        }
        int[] visit_list = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visit_list)) return false;
        }
        return true;
    }

    // status: 0 - undefined
    // 1- visiting，表示在递归栈
    // 2- visited，表示访问过并返回，这个节点是没有neighbor的或者有neighbor但是没有成环（由出度为0的节点自底向上返回而来）
    // 这样就能保证原有向图是无环的，他是可以进行拓扑排序的
    private boolean dfs(int cur, List<List<Integer>> graph, int[] visit_list) {
        if (visit_list[cur] == 1) return true;
        if (visit_list[cur] == 2) return false;
        visit_list[cur] = 1;
        // 访问所有neighbor进行dfs
        for (int next : graph.get(cur)) {
            if (dfs(next, graph, visit_list)) return true; // 成环了，不能topo，故返回true
        }
        visit_list[cur] = 2; // visited
        return false;
    }
}
