package lc714;

/**
 * Only 1 share of the stock can be bought or sold;
 * A stock can be bought or sold for multiple times in one day, but it has to be sold before being bought again;
 * The service fee is only charged when stock is sold;
 * Cash(i): the cash in hand, if you are not holding the stock at the end of day(i):
 * You might be not holding the stock at the end of day(i-1), and do nothing in day(i): a = cash(i-1); or
 * You might be holding the stock at the end of day(i-1), and sell it at the end of day(i):
 * b = hold(i-1) + prices[i] - fee;
 * Choose the greatest one as the value of cash(i) to get the greater potential profit:
 * cash(i) = max(a, b) = max(cash(i-1), hold(i-1) + prices[i] - fee);
 *
 * Hold(i): the cash in hand, if you are holding the stock at the end of day(i):
 * You might be holding the stock at the end of day(i-1), and do nothing in day(i): a = hold(i-1); or
 * You might be not holding the stock at the end of day(i-1), and buy it at the end of day(i): b = cash(i-1) - prices[i]; or
 * You might be holding the stock at the end of day(i-1), sell it on day(i), and buy it again at the end of day(i):
 * c = (hold(i-1) + prices[i] - fee) - prices[i];
 * Choose the greatest one as the value of hold(i) to get the greater potential profit:
 * hold(i) = max(a,b,c)
 * Because max(b, c) = max(cash(i-1), hold(i-1) + prices[i] - fee) - prices[i] = cash(i) - prices[i],
 * so hold(i) = max(hold(i-1), cash(i) - prices[i]);
 */

/**
 * 这题虽然看起来是DP，但其实每一天都采取利益最大化策略，其实就是一种Greedy做法了
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 最后的目的是要现金足够多
            cash = Math.max(cash, hold + prices[i] - fee); // 当天卖掉
            hold = Math.max(hold, cash - prices[i]); // 当天买入
        }

        return cash;
    }
}
