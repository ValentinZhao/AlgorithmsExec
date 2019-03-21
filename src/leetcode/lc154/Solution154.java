package lc154;

public class Solution154 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[n-1] > nums[0]) return nums[0];
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[hi] < nums[mid]) lo = mid + 1;
            else if (nums[hi] > nums[mid]) hi = mid;
            else hi--;
        }
        return nums[lo];
    }
}
