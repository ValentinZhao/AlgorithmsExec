package lc035;

/**
 * 经典二分查找
 */
public class Solution035 {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                if (mid - 1 >= 0 && nums[mid-1] < target) return mid;
                hi = mid;
            } else {
                if (mid + 1 < nums.length && nums[mid+1] > target) return mid+1;
                lo = mid + 1;
            }
        }
        return lo;
    }
}
