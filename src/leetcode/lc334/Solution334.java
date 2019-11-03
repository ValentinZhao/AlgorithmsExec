package lc334;

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= min) min = n; // 这时候n是最小的
            else if (n <= secMin) secMin = n; // 这时候n大于min但小于secMin，我们更新secMin
            else return true; // 同时大于min和secMin，triplet完成
        }

        return false;
    }
}
