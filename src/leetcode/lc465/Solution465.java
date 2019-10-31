package lc465;

import java.util.*;

public class Solution465 {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> balance = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] t : transactions) {
            graph.putIfAbsent(t[0], new HashMap<>());
            graph.get(t[0]).put(t[1], t[2]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(transactions[0][0]);

        while (!queue.isEmpty()) {
            int sender = queue.poll();
            visited.add(sender);
            balance.putIfAbsent(sender, 0);
            if (!graph.containsKey(sender)) continue;
            for (Map.Entry<Integer, Integer> neighbor : graph.get(sender).entrySet()) {
                int receiver = neighbor.getKey();
                int amount = neighbor.getValue();
                balance.put(sender, balance.get(sender) - amount);
                balance.putIfAbsent(receiver, 0);
                balance.put(receiver, balance.get(receiver) + amount);
                if (!visited.contains(receiver)) queue.offer(receiver);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> b : balance.entrySet()) {
            if (b.getValue() < 0) count++;
        }

        return count;
    }
}

class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        return settle(0, new ArrayList<>(m.values()));
    }

    int settle(int start, List<Integer> debt) {
        while (start < debt.size() && debt.get(start) == 0)
            start++;
        if (start == debt.size()) return 0;
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++)
            // we look for all other debts debt[i] (i>0) which have opposite sign to debt[0]
            if (debt.get(start) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                r = Math.min(r, 1 + settle(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        return r;
    }
}
