package lc324;

import lc215.Solution215;

import java.util.Random;

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
        // n | 1 gets the next odd number to n if it was even
        /**
         * So let's think about the first group in the odd slots, all numbers is the left side of the array should go into these odd slots.
         * What's the formula for it? Naturally it would be:
         * (1 + 2 x index) % n
         *
         * All these indexes are less than n / 2 so multiplying by 2 and add 1 (to make them go to odd place)
         * and then mod by n will always guarantee that they are less than n.
         *
         * Original Index => Mapped Index
         * 0 => (1 + 2 x 0) % 6 = 1 % 6 = 1
         * 1 => (1 + 2 x 1) % 6 = 3 % 6 = 3
         * 2 => (1 + 2 x 2) % 6 = 5 % 6 = 5
         *
         * These are what's less than median, if we continue this with indexes 3, 4, 5 we will cycle again:
         * 3 => (1 + 2 x 3) % 6 = 7 % 6 = 1
         * 4 => (1 + 2 x 4) % 6 = 9 % 6 = 3
         * 5 => (1 + 2 x 5) % 6 = 11 % 6 = 5
         *
         * and we don't want that, so for indexes larger than n/2 we want them to be even, (n|1) does that exactly.
         * What n|1 does it that it gets the next odd number to n if it was even
         * if n = 6 for example 110 | 1 = 111 = 7
         * if n = 7 for example 111 | 1 = 111 = 7
         *
         * and this is what we want, instead of cycling the odd numbers again we want them to be even,
         * and odd % odd number is even so updating the formula to:
         * (1 + 2*index) % (n | 1)
         *
         * Then we have:
         * 3 => (1 + 2 x 3) % 7 = 7 % 7 = 0
         * 4 => (1 + 2 x 4) % 7 = 9 % 7 = 2
         * 5 => (1 + 2 x 5) % 7 = 11 % 7 = 4
         */
        return (1 + 2*index) % (n | 1);
    }

    private void swap(int[] num, int i, int j) {
        int temp = 0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 0) return;
        int median = findKthLargest(nums, (n + 1) / 2);
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            // 以median为界
            if (nums[wigIndex(i, n)] > median) swap(nums, wigIndex(left++, n), wigIndex(i++, n));
            else if (nums[wigIndex(i, n)] < median) swap(nums, wigIndex(right--, n), wigIndex(i, n));
            else i++;
        }
    }

    private int wigIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else break;
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (i < hi && nums[++i] < nums[lo]);
            while (j > lo && nums[--j] > nums[lo]);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}