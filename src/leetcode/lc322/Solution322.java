package lc322;

/**
 * 0-1背包问题，二维动态规划问题，可以降维
 * 我们利用遍历amount的方式，将dp[i]作为当前amount下的所有解得集合，那么在遍历到任意coin的值的时候
 * 我们只需要取dp[i]和dp[i-coin]+1（意思是在总额为i-coin加上一枚coin面值的硬币的所有情况，那不就是dp[i-coin]+1嘛）的较小值即可
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_fffe;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = 0x7fffffff;
            for (int j = 0; j < coins.length; j++)
                if (i >= coins[j] && dp[i - coins[j]] != 0x7fffffff)  //①
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
        return dp[amount] == 0x7fffffff ? -1 : dp[amount];
    }
}
