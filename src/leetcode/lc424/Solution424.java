package lc424;

public class Solution424 {
    public int characterReplacement(String s, int k) {
        int maxCount = 0, start = 0, maxSize = 0;
        int[] count = new int[26];

        /**
         * 一个合格的窗口是大部分是重复字符，然后一共有k个字符是不一样的
         * 其实把思路调转过来，我们不用管哪些要被调转，我们只管重复序列有多长，再用目前窗口长度减一下就好了
         */
        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']); // 窗口中将要被重复的字符目前的数量
            if (end - start + 1 - maxCount > k) { // 要被转化的字符数多余k，现在end-start+1是窗口大小，这时候我们该缩小了
                count[s.charAt(start++) - 'A']--;
            }
            maxSize = Math.max(maxSize, end - start + 1);
        }
        return maxSize;
    }
}
