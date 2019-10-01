package lc935;

public class Solution935 {
    private final int MOD = (int) 1e9 + 7;
    private int[][] graph = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0},
            {},{1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    public int knightDialer(int N) {
        // dp[i][j]表示，还剩i步的时候，对应的j还有几种组合方式
        int[][] dp = new int[N+1][10];
        for (int i = 0; i < 10; i++) dp[1][i] = 1;

        // 注意，这里从i=2开始，因为我们要求一位dp[i-1][j]
        // 如果从i=1开始，那就取到了dp[0][j]，是不存在的
        for (int i = 2; i <= N; i++) {
            // 0-9，有10个数
            for (int j = 0; j < 10; j++) {
                for (int neighbor : graph[j]) {
                    dp[i][j] += dp[i-1][neighbor];
                    dp[i][j] %= MOD;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            cnt += dp[N][i];
            dp[N][i] %= MOD;
        }
        return cnt;
    }
}
