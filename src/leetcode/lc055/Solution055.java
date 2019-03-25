package lc055;

public class Solution055 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max); // nums[i] + i表示这个位置可以到达的最远距离
        }
        return true;
    }
}
