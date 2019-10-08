package lc028;

public class Solution028 {
    public int strStr(String haystack, String needle) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                // 只有当j位置和i+j位置不断匹配，j才会不断累加
                // 否则下面会break，i进一位并且j归零
                if (j == needle.length()) return i;
                // 那么由于j还未匹配完，这时候已经匹配到了haystack的尽头，一定是找不到的了
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }
    }
}
