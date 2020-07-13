package bytedance.leetcode;

import java.util.Arrays;

/**
 * 这题dp[n]代表总数为n的时候，可以有多少种硬币组合模式，那么状态转移方程就是dp[n] = min(dp[n], dp[n-coinValue] + 1)
 * 因为要尽量小，并且选用当前coin value的时候（加了一枚硬币）
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); // 填充较大的值，因为我们后面用math.min来减小
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
