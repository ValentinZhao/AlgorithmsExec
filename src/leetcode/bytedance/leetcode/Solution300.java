package bytedance.leetcode;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int[] dp = new int[nums.length];
        int index = 0;
        dp[index++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[index-1]) dp[index++] = nums[i];
            else {
                int k = binarySearch(dp, index, nums[i]);
                dp[k] = nums[i];
            }
        }

        return index;
    }

    private int binarySearch(int[] num, int len, int target) {
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (num[mid] == target) return mid;
            else if (num[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return lo;
    }
}
