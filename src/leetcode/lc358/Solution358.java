package lc358;

import java.util.*;

public class Solution358 {
    public String rearrangeString(String str, int k) {
        StringBuilder builder = new StringBuilder();
        // 某个字符出现了几次
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            builder.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            queue.offer(curr);
            if (queue.size() < k) continue;
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) pq.offer(front);
        }

        // 因为如果是不能rearrange的话，我们会发现maxHeap推空后，queue里面还有东西
        // 这是因为按照我们的规则，原字符串并不够长导致的，所以直接返回空串
        return builder.length() == str.length() ? builder.toString() : "";
    }

}