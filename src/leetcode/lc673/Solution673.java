package lc673;

/**
 * DP题！
 *
 Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        // 维护两个数组
        // len[i]，代表以i为尾的子数组中最长递增子序列的长度
        // count[i]，代表以i为尾的子序列中存在的最长递增子序列的数量
        int n = nums.length;
        int max_len = 0;
        int result = 0;
        int[] len = new int[n], count = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) count[i] += count[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (max_len == len[i]) result += count[i];
            if (max_len < len[i]) {
                max_len = len[i];
                result = count[i];
            }
        }
        return result;
    }
}
