package lc309;

/**
 * 此题还是采用dp，主要是状态转移不太好想，我们设定buy[i]是截止到第i天，当第i天是买入时的最大利润
 * 那么sell[i]是同理的，第i天是卖出时的最大利润，方程为
 *
 * sell[i] = max(buy[i-1]+price[i], sell[i-1]-price[i-1]+price[i]);
 * 也就是说第i天卖出的话，有两种情况，一种是前一天买了，当天卖出；另一种是前一天卖了，前一天也买了然后到当天卖出；
 *
 * buy[i] = max(sell[i-2]-price[i], buy[i-1]+price[i-1]-price[i])
 * 那么第i天是买入的话，有两种情况，一种是在i-2那天卖出，然后一天的cooldown，然后第i天买入；要不就是第i-1天买入，那天又卖出，然后第i天买入
 *
 * 那么由于最后一步的操作绝对是卖出，那么自然sell[n]自然是结果了
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(buy[i-1]+prices[i], sell[i-1]-prices[i-1]+prices[i]);
            if (res < sell[i]) res = sell[i];
            if (i == 1) buy[i] = buy[0] + prices[0] - prices[1]; // 第2天买的情况就直接写出来，毕竟我们的公式是有i-2的元素的，i=1的时候会越界
            else buy[i] = Math.max(sell[i-2]-prices[i], buy[i-1]+prices[i-1]-prices[i]);
        }
        return res;
    }
}
