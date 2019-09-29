package lc416;

/**
 * 那么这道题其实是经典0-1背包问题。给定选中的值sum，让你选择几个值正好等于这个的。
 * 我们也知道应该用dp解决。那么dp[i][j]的意思是，对于前i个数，是否存在sum为j的subset
 * 那我们有两个选择，选择不拿i处的值，那么dp[i][j] == dp[i-1][j]
 * 如果我们选择拿，那么就是dp[i][j] == dp[i-1][j-nums[i]]，很容易理解
 *
 * 基本条件，dp[0][0] = true，转移方程如上，那么这题可解
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        // 对于此题来说，我们要选两个数，正好和另两个数相等
        // 其实就相当于选两个数正好等于数列和一半
        int sum = 0;
        for (int num : nums) sum += num;
        if((sum&1)==1) return false; // 判断是否是偶数
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true; // 空串和为0，肯定为true
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true; //和为0的话，我们只要一直不取数字就可以了，所以全是true
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false; // 空串是不可能能加出大于0的sum的
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // 因为有可能nums[i-1]本身就很大了，根本无法选用
                // 所以就不存在dp[i][j] == dp[i-1][j-nums[i]]的情况
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    // 这块，由于我们是从1开始的，但是呢nums又要映射回正确的index，所以要减一
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
