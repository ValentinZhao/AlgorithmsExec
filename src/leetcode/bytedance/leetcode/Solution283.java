package bytedance.leetcode;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] != 0) nums[pointer++] = nums[i];
        for (int i = pointer; i < nums.length; i++) nums[i] = 0;
    }
}
