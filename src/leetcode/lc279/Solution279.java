package lc279;

/**
 * dp[i]表示以i为底合为i的最小的平方和元素的个数
 */
public class Solution279 {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                // 任意一个数都可以分解为一个普通的数(i-j*j)和平方数(j*j)的和
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
