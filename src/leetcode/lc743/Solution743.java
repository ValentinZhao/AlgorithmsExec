package lc743;

/**
 * 这题是经典的有向图找最短路径问题，有两种办法Bell ford和djikstra法
 * 前者比较好理解，类似dp的做法，dp[i]是指从K到i所有节点的最短路径的和，所以到了dp[N]就是所有点的和了
 * 只有两点需要注意，一个是最后要检查一遍dp数组，如果有个节点没有被遍历到那说明原来的图有节点独立，直接返回-1，另一个是dp[k]=0
 */
public class Solution743 {
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
}
