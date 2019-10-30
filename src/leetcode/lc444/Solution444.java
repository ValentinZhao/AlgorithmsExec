package lc444;

import java.util.*;

public class Solution444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            // 就是初始化所有节点的neighbor和各个点入度，巧妙的使用set.add()好评
            if (seq.size() == 1) {
                graph.put(seq.get(0), new HashSet<>());
                indegree.put(seq.get(0), 0);
            } else {
                for (int i = 0; i < seq.size()-1; i++) {
                    if (!graph.containsKey(seq.get(i))) {
                        graph.put(seq.get(i), new HashSet<>());
                        indegree.put(seq.get(i), 0);
                    }
                    if (!graph.containsKey(seq.get(i+1))) {
                        graph.put(seq.get(i+1), new HashSet<>());
                        indegree.put(seq.get(i+1), 0);
                    }
                    if (graph.get(seq.get(i)).add(seq.get(i+1))) {
                        indegree.put(seq.get(i+1), indegree.get(seq.get(i+1))+1);
                    }
                }
            }
        }

        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) queue.offer(entry.getKey());
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) return false;
            int curr = queue.poll();
            if (index == org.length || curr != org[index++]) return false;
            for (int neighbor : graph.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if (indegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }

        return index == org.length && index == graph.size();
    }
}
