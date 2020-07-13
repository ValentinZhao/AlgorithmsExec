package bytedance.leetcode;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return Integer.MAX_VALUE;
        return helper(nums, 0, nums.length-1, nums.length-k);
    }

    private int helper(int[] nums, int start, int end, int k) {
        if (start > end) return Integer.MAX_VALUE;
        int pivot = nums[end], left = start;
        for (int i = start; i < end; i++) {
            if (pivot >= nums[i]) swap(nums, i, left++);
        }
        swap(nums, left, end);
        if (left == k) return nums[left];
        else if (left < k) return helper(nums, left + 1, end, k);
        else return helper(nums, start, left - 1, k);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
