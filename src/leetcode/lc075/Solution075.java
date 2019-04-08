package lc075;

/**
 * 把2移向右边，把0移向左边，剩下1都在中间了
 */
public class Solution075 {
    public void sortColors(int[] nums) {
        int pivot0 = 0;
        int pivot2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            // 先把2都移向右边
            if (nums[i] == 2) {
                while (nums[i] == 2 && i < pivot2) {
                    int tmp = nums[pivot2];
                    nums[pivot2] = nums[i];
                    nums[i] = tmp;
                    pivot2--;
                }
            }
            if (nums[i] == 0) {
                int tmp = nums[pivot0];
                nums[pivot0] = nums[i];
                nums[i] = tmp;
                pivot0++;
            }
        }
    }
}
