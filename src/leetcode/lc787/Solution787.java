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

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] f : flights) {
            if (!graph.containsKey(f[0])) graph.put(f[0], new HashMap<>());
            graph.get(f[0]).put(f[1], f[2]);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, src, K+1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int price = cur[0];
            int place = cur[1];
            int stop = cur[2];
            if (place == dst) return price;
            if (stop > 0) {
                Map<Integer, Integer> neighbors = graph.getOrDefault(place, new HashMap<>());
                for (int a : neighbors.keySet()) {
                    queue.offer(new int[]{price+neighbors.get(a), a, stop-1});
                }
            }
        }
        return -1;
    }
}