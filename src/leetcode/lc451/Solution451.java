package lc451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue()-a.getValue()
        );
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) pq.offer(entry);
        while (!pq.isEmpty()) {
            Map.Entry entry = pq.poll();
            for (int i = 0; i < (int) entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
