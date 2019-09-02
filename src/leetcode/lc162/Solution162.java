package lc162;

/**
 * 还是二分查找，peak值是比左边和右边的大，所以二分查找每次和右边的比，如果nums[mid] > nums[mid+1]
 * 的话，说明要找的值应该在左边，且比nums[mid]小才对，vice versa
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid+1]) hi = mid; // 去左边找小值
            else if (nums[mid] < nums[mid+1]) lo = mid + 1; // 去右边找大值
        }
        return lo;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid+1]) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}