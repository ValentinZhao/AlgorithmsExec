package lc053;

/**
 * 经典DP题，使用dp数组记录下以i为结尾的目前子序列最大的sum，然后不断更新dp数组和max值，最后返回max值
 */
public class Solution053 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            // 因为本题我们并不需要输出这个子序列是什么，所以简单粗暴的处理就是前面的和如果是负的就全部舍弃直接加0
            // 这样做的目的就是，因为我们是从头开始，dp记录是到每个元素的最大和子序列，也就是nums[0...j]这样的序列
            // 很明显看出这会丢掉一部分，也就是nums[i...j]的所有序列。但是我们直接舍弃掉负数和，这就排除了所有会使得和变小的因素
            // 这些情况中往往就存在nums[i...j]的情况
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
