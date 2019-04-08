package lc179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 当你在比较两个数字的时候，只有两种情况
 *
 * String s1 = "9";
 * String s2 = "31";
 *
 * String case1 =  s1 + s2; // 931
 * String case2 = s2 + s1; // 319
 * 那么我们就用这个来写一个Comparator然后用Arrays.sort即可了
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String num1 = o1+o2;
                String num2 = o2+o1;
                return num2.compareTo(num1);
            }
        };
        Arrays.sort(numStrs, comparator);
        if (numStrs[0].charAt(0) == '0') return "0";
        StringBuilder builder = new StringBuilder();
        for (String numStr : numStrs) {
            builder.append(numStr);
        }
        return builder.toString();
    }
}
