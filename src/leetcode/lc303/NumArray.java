package lc303;

public class NumArray {
    private int[] dp;
    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        this.dp = nums;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return this.dp[j];
        return this.dp[j] - this.dp[i-1];
    }
}

