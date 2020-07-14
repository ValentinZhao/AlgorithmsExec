package bytedance.leetcode;

public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, left = 0, right = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[right++];

            while (sum >= s) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
