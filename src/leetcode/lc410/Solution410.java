package lc410;

/**
 * 本题使用DP比较直截了当，我们定义二维DP，dp[i][j]表示把 nums[0...i] 分成 j 部分。
 * 当我们要分成两段时，我们会发现分割点不一样会导致不一样的结果，所以我们需要把当前能切割的部分都遍历一次来保留一个最大的结果。
 * 毕竟本题最后要的是在各分割方法中的最大值中的最小值是多少。所以我们在分割时都是要取最大值的。
 * 初始状态 dp[i][1] = sum(0...i) 状态转移 dp[i][j] = min(dp[i][j], max(dp[k][j-1], sum(k+1, i)))
 */
public class Solution410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        int[] sums = new int[n];
        // 要小于等于才能给到n和m二维数组位置上
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                   dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sums[i]-sums[k]));
                }
            }
        }
        return dp[n][m];
    }
}
