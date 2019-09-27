package lc523;

import java.util.HashMap;
import java.util.Map;

// very tricky
// a % k == (a + n*k) % k
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // map means runningSum -> index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                // 需要最少两个元素在continuous subarray里面
                if (i - prev > 1) return true;
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }
}
