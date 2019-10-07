package lc188;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        // dp[i][j]意为i次交易过后在第j天获得的最大收益
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            // tmp指目前手里还有多少钱，第一天必买入
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                // 这一天什么都不做，或者卖掉
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                // 这一天什么都不做，或者买入
                // 注意，你要买入的话，证明你今天是没卖出的，所以你手里的钱还是和前一天的少一次交易时的状况一样
                // 计算过后，你的手里钱应该还要在刨除当日股价
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
