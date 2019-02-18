package lc210;

import java.util.*;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }
        int[] visit_list = new int[numCourses];
        int[] result_arr = visit_list.clone();
        List<Integer> results = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visit_list, results)) return result_arr;
        }
        for (int i = 0; i < numCourses; i++) {
            result_arr[i] = results.get(i);
        }
        return result_arr;
    }

    private boolean dfs(int cur, List<List<Integer>> graph, int[] visit_list, List<Integer> results) {
        if (visit_list[cur] == 1) return true;
        if (visit_list[cur] == 2) return false;

        visit_list[cur] = 1;
        for (int next : graph.get(cur)) {
            if (dfs(next, graph, visit_list, results)) return true;
        }
        results.add(cur);
        visit_list[cur] = 2;
        return false;
    }
}
