package lc494;

/**
 * 还是蛮简单的dfs题，对于数组的每一位，我们都用+和-尝试一次
 *
 * 还有很巧妙地DP解法
 * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
 */
public class Solution494 {
    int res = 0;
    // DFS法，比较简单粗暴
    public int findTargetSumWays(int[] nums, int S) {
        computeDFS(nums, 0, S, 0);
        return res;
    }

    private void computeDFS(int[] nums, int pos, int target, long sum) {
        if (pos == nums.length) {
            if (target == sum) res++;
            return;
        }
        computeDFS(nums, pos + 1, target, sum + nums[pos]);
        computeDFS(nums, pos + 1, target, sum - nums[pos]);
    }
}
