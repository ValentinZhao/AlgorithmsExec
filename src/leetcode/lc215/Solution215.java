package lc215;

import java.util.Random;

/**
 *  Quick select, using partition algorithm to select pivot
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
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
