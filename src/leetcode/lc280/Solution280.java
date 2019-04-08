package lc280;

public class Solution280 {
    public void wiggleSort(int[] nums) {
        int toggle = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i+1]-nums[i]) * toggle < 0) {
                int tmp = nums[i+1];
                nums[i+1] = nums[i];
                nums[i] = tmp;
            }
            toggle *= -1;
        }
    }
}
