package lc456;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int two = Integer.MIN_VALUE;
        int index = nums.length;
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] < two) return true;
            while (index < nums.length && nums[i] > nums[index]) {
                two = nums[index++];
            }
            nums[--index] = nums[i];
        }
        return false;
    }
}
