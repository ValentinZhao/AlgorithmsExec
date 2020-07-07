package bytedance.leetcode;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1, k = i;
        while (i > 0 && nums[i] <= nums[i-1]) i--;
        // 这时候i落在数组一开始的升序段的后面降序段的第一位，先把后面降序段全部reverse过来
        for (int j = i; j < k; j++, k--) {
            swap(nums, j, k);
        }

        if (i > 0) {
            k = i--; // i在升序最后一位，k在原降序（现在也已经被reverse）第一位，我们用k来找第一个比nums[i]大的值，替换一下完成next permutation
            while (k < nums.length && nums[k] <= nums[i]) k++;
            swap(nums, i, k);
        }

    }

    private void swap(int[] num, int i, int j) {
        int temp = 0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
