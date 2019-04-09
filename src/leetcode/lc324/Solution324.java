package lc324;

import lc215.Solution215;

/**
 * checkout
 * https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
 *
 *
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {
        Solution215 solution = new Solution215();
        int median = solution.findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    private void swap(int[] num, int i, int j) {
        int temp = 0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
