package bytedance.leetcode;

public class Solution121 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-:)-(In-case-if-interviewer-twists-the-input)/36798
    // 该解法的link
    public int maxProfit(int[] prices) {
        int maxSum = 0, maxCur = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i-1];
            maxCur = Math.max(0, maxCur); // 不断累积前缀和，如果这一段因为某天是负数整体小于零了，就归零重新开始的意思
            maxSum = Math.max(maxSum, maxCur);
        }

        return maxSum;
    }

    // straightforward solution
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int maxProfit = 0, minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }

        return maxProfit;
    }
}
