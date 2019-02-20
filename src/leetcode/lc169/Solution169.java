package lc169;

/**
 * 求众数，moore voting
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int major = 0, count = 0;
        for (int num : nums) {
            if (count == 0) major = num;
            if (major != num) count--;
            else count++;
        }
        return major;
    }
}
