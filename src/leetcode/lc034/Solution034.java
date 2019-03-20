package lc034;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int start = getFirstEqualGreater(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1,-1};
        return new int[]{start, getFirstEqualGreater(nums, target + 1) - 1};
    }

    // 这个方法返回第一个match target的index值，如果target是不存在的话就会返回比他大的那个数的index值
    private int getFirstEqualGreater(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
