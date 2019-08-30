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

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return Integer.MAX_VALUE;
        // 因为我们是从结尾处pivot开始，把比他小的放在左面，那么其实我们做完快速选择其实是选出了前k个最小的
        // 那么我们就需要取numLength - k才是最大的k个
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end) return Integer.MAX_VALUE;
        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, left++, i); // Put numbers < pivot to pivot's left
            }
        }
        swap(nums, left, end); // Finally, swap A[end] with A[left]
        if (left == k) return nums[left];
        else if (left < k) return findKthLargest(nums, left + 1, end, k);
        else return findKthLargest(nums, start, left - 1, k);
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}