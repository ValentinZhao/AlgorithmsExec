package bytedance.leetcode;

public class Solution33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            // 注意这个地方去比较左边的，是nums[mid]不是target！！！
            else if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                // 这时候其实是比如旋转了很少一部分到前面（那前面的值是很大的），target没有nums[lo]大，这时候target很有可能在后半段
                // 这样的话就要和nums[hi]来比较
                if (nums[hi] >= target && target > nums[mid]) lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return -1;
    }
}
