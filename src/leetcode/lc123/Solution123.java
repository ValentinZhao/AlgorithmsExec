package lc123;

/**
 * 我们首先疯狂寻找第一次购买可以到达的最大利润，就像该系列的第一题一样
 * 之后很trick的是，我们把第一次的利润尽量作为第二次购买的一部分成本来抵掉（这就是为什么15行我们当前购买的price其实是price-sell1）
 * 并通过max和min函数来尽量的达到另一个最大利润
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
