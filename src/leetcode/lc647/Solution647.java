package lc647;

/**
 * 非常巧妙的方法，先遍历整个数组的每个元素本身，然后再把这个指针"分成两个"，相当于一个按照奇数个查找一个按照偶数个查找，details:
 *
 * https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
 */

public class Solution647 {
    private int count = 1;
    public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        for (int i = 0; i < s.length() - 1; i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void checkPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            // 向两边扩散
            i--;
            j++;
            count++;
        }
    }
}
