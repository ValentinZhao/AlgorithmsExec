package lc1202;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1202 {

    private int[] parent;


    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0) {
            return null;
        }
        parent = new int[s.length()];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(chs[i]);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chs.length; i++) {
            builder.append(map.get(i).poll());
        }

        return builder.toString();

    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return parent[x];
    }

    private void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (rb > ra) {
            parent[rb] = ra;
        } else {
            parent[ra] = rb;
        }
    }
}
