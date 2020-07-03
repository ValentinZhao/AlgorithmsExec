package jianzhi;

/**
 * 该题目思路:
 * dp[i]表示以元素array[i]结尾的最大连续子数组和.
 * 以[-2,-3,4,-1,-2,1,5,-3]为例
 * 可以发现,
 * dp[0] = -2
 * dp[1] = -3
 * dp[2] = 4
 * dp[3] = 3
 * 以此类推,会发现
 * dp[i] = max{dp[i-1]+array[i],array[i]}.
 */
public class Jz30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = array[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
