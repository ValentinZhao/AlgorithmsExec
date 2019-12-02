package lc743;

import java.util.*;

/**
 * 这题是经典的有向图找最短路径问题，有两种办法Bellman ford和Dijkstra法
 * 前者比较好理解，类似dp的做法，dp[i]是指从K到i所有节点的最短路径的和，所以到了dp[N]就是所有点的和了
 * 只有两点需要注意，一个是最后要检查一遍dp数组，如果有个节点没有被遍历到那说明原来的图有节点独立，直接返回-1，另一个是dp[k]=0
 */
public class Solution743 {
    // Bellman Ford
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) return -1;
        int[] dp = new int[N+1];
        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[K] = 0;
        for (int i = 0; i < N; i++) {
            for (int[] time : times) {
                int u = time[0], v = time[1], w = time[2];
                // 一开始只能是从K出发所以下面这个判断只有K一开始能进，然后更新dp[v]
                if (dp[u] != Integer.MAX_VALUE && dp[v] > dp[u] + w) {
                    dp[v] = dp[u] + w;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    // Dijkstra
    // 它更像是一种BFS的办法，由于无需重复访问节点时间效率上必然更高
    public int networkDelayTime2(int[][] times, int N, int K) {
        if (times == null || times.length == 0) return -1;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        // 构建一个图，index表示source，值表示target和edge的数值
        // 由于本题都是int所以用ArrayList即可，一般我们使用Map来存储复杂对象
        for (int[] time : times) graph.get(time[0]).add(new int[]{time[1], time[2]});
        // 维护一个PQ，作用是保存K到目标的最小距离，因为可能这样的路径在后面的计算中有多条，我们只取最短的
        // 后面我们存入值的时，都是先取出原来的距离，再遍历neighbor，把每个neighbor的距离加上原来的距离就得到K到neighbor的距离了，再塞回PQ
        // 这里[K,0]代表【target，到target的距离】，K到K的距离必然是0
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{K, 0});
        // 最后再用一个Set来保存访问的情况，不同于Bellman，在这里由于是BFS，访问过的节点不应该再访问
        Set<Integer> visited = new HashSet<>();
        int dist = 0;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (!visited.add(cur[0])) continue;
            // 这样的话，由于一个点访问所有邻居是**同时**的，那么我们计算遍历全部点最长时间
            // 其实就是找路径最长路径所花费的时间，一个点到它的所有邻居花费时间只有最大的那一条的时间，而不是全部时间的累和
            // 累和的状况只有一条路径不断向下进入
            dist = cur[1];
            for (int[] neighbor : graph.get(cur[0])) {
                if (!visited.contains(neighbor[0])) {
                    // cur[1]是K到当前节点长度，neighbor[1]是当前节点到当前这个neighbor的距离，加起来就是K到当前节点的当前neighbor距离
                    minHeap.offer(new int[]{neighbor[0], neighbor[1] + cur[1]});
                }
            }
        }
        return visited.size() == N ? dist : -1;
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) return -1;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int[] time : times) graph.get(time[0]).add(new int[]{time[1], time[2]});
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        int dist = 0;
        minHeap.offer(new int[]{K, 0});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (!visited.add(cur[0])) continue;
            dist = cur[1];
            for (int[] neighbor : graph.get(cur[0])) {
                if (!visited.contains(neighbor[0])) {
                    minHeap.offer(new int[]{neighbor[0], neighbor[1] + cur[1]});
                }
            }
        }
        return visited.size() == N ? dist : -1;
    }
}













