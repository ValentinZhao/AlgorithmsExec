package lc081;

public class Solution081 {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            while (lo < hi && nums[lo] == nums[lo+1]) lo++;
            while (hi > lo && nums[hi] == nums[hi-1]) hi--;
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;

            // 如果middle值在pivot分割的前一半里
            if (nums[mid] > nums[hi]) {
                if (target < nums[mid] && target >= nums[lo]) hi = mid - 1;
                else lo = mid + 1;
            } else if (nums[mid] < nums[lo]) {
                // middle在右边一半
                if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else { // 没有rotate，直接二分查找
                if (nums[mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }
}
