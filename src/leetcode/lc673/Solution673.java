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

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;int res = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                // 存在一个递增的话
                if (nums[i] > nums[j]) {
                    // 如果在i之前的某一位，最长递增长度只比i短一位，那么直接把cnt[i]加上所有cnt[j]
                    // 因为j一定是比i小的，最大的j就正好是i-1，那么LIS的长度只差一位，说明这正好是len[i]的一部分
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                    // 这时候我们发现原来记录的len[i]还没有他的子集遍历中发现的LIS更长，那么我们就直接更新为这个值
                    else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            // maxLen记录的是上一位的最长LIS，如果这一步的LIS还是一样的
            // 说明这一位的LIS个数要加上历史所有个数加上目前cnt
            if (maxLen == len[i]) res += cnt[i];
            else if (maxLen < len[i]) {
                maxLen = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
