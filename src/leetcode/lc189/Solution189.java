package lc189;

/**
 * 这题如果加上space O(1) 和 in-place的要求还是挺难的，思路是
 *
 * Original List                   : 1 2 3 4 5 6 7
 * After reversing all numbers     : 7 6 5 4 3 2 1
 * After reversing first k numbers : 5 6 7 4 3 2 1
 * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;end--;
        }
    }
}
