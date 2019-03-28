package lc312;

/**
 * 一个详细解释，非常经典的Divide & Conquer
 *
 * https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
 */
public class Solution312 {
    public int maxCoins(int[] nums) {
        int[] ballons = new int[nums.length + 2]; // 左右加个气球代表所有气球的两边的位置，value为1
        int n = 1;
        for (int ballon : nums) ballons[n++] = ballon;
        ballons[0] = ballons[n++] = 1;
        int[][] memo = new int[n][n];
        int res = burst(memo, ballons, 0, n-1);
        return res;
    }

    private int burst(int[][] memo, int[] ballons, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int maxValue = 0;
        for (int i = left + 1; i < right; i++) {
            maxValue = Math.max(maxValue, ballons[left]*ballons[i]*ballons[right] +
                    burst(memo, ballons, left, i) + burst(memo, ballons, i, right));
        }
        memo[left][right] = maxValue;
        return maxValue;
    }
}
