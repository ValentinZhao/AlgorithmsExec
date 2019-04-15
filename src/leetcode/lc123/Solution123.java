package lc123;

/**
 * 其实就是多次计算手里还有多少钱，其中buy1，buy2都有可能是负数，这时候是指买入后手里还有余钱
 * 这时候price-buy1 price-buy2其实就是卖出价加上手里的余额
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE,
                sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            sell1 = Math.max(sell1, price - buy1);
            buy2 = Math.min(buy2, price - sell1);
            sell2 = Math.max(sell2,price-buy2);
        }
        return sell2;
    }
}
