package lc540;

public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((mid % 2 == 0 && mid + 1 < n && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && mid - 1 >= 0 && nums[mid] == nums[mid - 1]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return nums[lo];
    }
}
