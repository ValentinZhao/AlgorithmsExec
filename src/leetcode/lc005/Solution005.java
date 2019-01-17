package lc005;

/**
 * 最长回文子串问题，本题我们使用的方法是在这个字符串的每个节点，都按照规则向前向后推进指针，这样就能保证所有的最长回文串都能被便利到
 */

public class Solution005 {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        // k - j - 1才是这个循环内最长子串的长度，因为在上面那个while退出的时候k和j多退了一位，所以要补回来1
        // 同理，子串起始点也应该是j + 1
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
