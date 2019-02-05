package lc283;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pointer = 0;
        for (int num : nums) if (num != 0) nums[pointer++] = num;
        for (int i = pointer; i < nums.length; i++) nums[i] = 0;
    }
}