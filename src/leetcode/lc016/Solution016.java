package lc016;

import java.util.Arrays;

/**
 * 基本思路还是就是设置三个指针，首尾，和一个current，每次外层循环会把首尾给确定，然后把current置为start+1，然后不断收cur和end并比较
 * 然后再把首指针往前推，再继续比，O(n^2)
 */
public class Solution016 {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) end--;
                else start++;
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }
        return result;
    }
}
