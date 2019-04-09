package lc246;

public class Solution246 {
    public boolean isStrobogrammatic(String num) {
        char[] nums = num.toCharArray();
        return checkStro(nums, 0, nums.length-1);
    }

    private boolean checkStro(char[] nums, int lo, int hi) {
        if (lo > hi) return true;
        if (lo == hi) {
            if (    nums[lo] == '1' ||
                    nums[lo] == '8' ||
                    nums[lo] == '0') return true;
            return false;
        }
        if (    (nums[lo] == '1' && nums[hi] == '1') ||
                (nums[lo] == '0' && nums[hi] == '0') ||
                (nums[lo] == '8' && nums[hi] == '8') ||
                (nums[lo] == '6' && nums[hi] == '9') ||
                (nums[lo] == '9' && nums[hi] == '6')) {
            return checkStro(nums, lo+1, hi-1);
        }
        return false;
    }
}
