package lc787;

import java.util.*;

/**
 * 利用Dijkstra的思想，解决类似有向图最短路径
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, src, K+1});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> neighbors = prices.getOrDefault(city, new HashMap<>());
                for (int a : neighbors.keySet()) {
                    queue.offer(new int[]{price+neighbors.get(a), a, stops-1});
                }
            }
        }
        return -1;
    }
}
