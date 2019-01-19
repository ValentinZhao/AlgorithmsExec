package lc014;

import java.util.Arrays;

/**
 * 寻找一个数组内所有字符串的公共最长前缀，那么（optimized）思路就是先遍历一遍数组，找出最长和最短的那两个字符串
 * 目的在于，因为是要找所有的字符串的公共最长前缀，那按照一般的思路是把所有的字符串都比对一次
 * 其实，就算是类似["fl", "flgg", "flower", "fgbgbgg"]这种数组，你公共最长前缀也只能是"f"，所以我们发现中间长度的字符串没有比对的意义，只需要比较最长最短的
 * 然后循环比对每一位，找到最后的相同一位的index，再用substring取最小字符串即可
 */
public class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        Arrays.sort(strs);
        char[] min = strs[0].toCharArray();
        char[] max = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < min.length; i++) if (min[i] != max[i]) return strs[0].substring(0, i);
        return strs[0];
    }
}
