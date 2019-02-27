package lc159;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要思想就是记录下各个字符出现的频率，多于两个字符的话就把start往前推，直到多余的字符计数为0才把字符种类降下来，直到最后
 */
public class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, end = 0, cntCharType = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end); // end相当于是一个向前推进的指针，循环开始肯定是取end处的字符
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) cntCharType++;
            end++;
            while (cntCharType > 2) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if (map.get(cTemp) == 0) cntCharType--;
                start++; // 这时候种类超过了2，所以window的头肯定要向后移
            }
            // len的话，确实存在一种类似"eeeeeddccc"的字符串，它最长的valid字符串是"eeeedd"，length是6
            // 然而读到最后sliding window里面的字符串是"ddccc"
            // 所以我们要用Math.max来保存一个最长的字符串长度，避免这种情况把它覆盖掉
            len = Math.max(len, end - start);
        }
        return len;
    }
}
