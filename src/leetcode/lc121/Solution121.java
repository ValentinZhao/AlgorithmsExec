package lc121;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSum = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSum = Math.max(maxCur, maxSum);
        }
        return maxSum;
    }
}
