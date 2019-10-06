package lc398;

import java.util.Random;

public class Solution398 {
    int[] nums;
    public Solution398(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            count++;
            if (new Random().nextInt(count) == 0) res = i;
        }
        return res;
    }
}
