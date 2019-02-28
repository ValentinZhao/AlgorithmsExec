package lc010;

/**
 * 用二维DP数组来维护一个布尔表，dp[i][j]代表匹配到该位置的真假
 * 二维数组的行代表原始字符串，按照每一个字符一位
 * 列代表RegExp字符串，每个字符一位
 *
 * https://blog.csdn.net/hk2291976/article/details/51165010
 */
public class Solution010 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int strLen = s.length(), patrLen = p.length();
        boolean dp[][] = new boolean[strLen+1][patrLen+1];
        // 初始化第一行，除了[0][0]全为false，毕竟当RegExp为空串时，只有原来的也是空串才能匹配
        for (int i = 1; i <= strLen; i++) dp[i][0] = false;
        // 初始化第一列，只有a*能匹配空串，如果有*，它的真值一定和p[0][j-2]的相同（略过它之前的符号）
        // 注意，从1开始，j-1才是原来的位置，j-2就是*号前面的那个字符
        for (int j = 1; j <= patrLen; j++) {
            dp[0][j] = j > 1 && p.charAt(j-1) == '*' && dp[0][j-2];
        }
        for (int i = 1; i <= strLen; i++) {
            for (int j = 1; j <= patrLen; j++) {
                // j-1才是原本字符的位置，当*表示令前面字符为空串时，此处的dp就直接等同于j-2处的真值
                // 不表示空串时，只有j-2处的字符和i-1的字符相等才行，这时候就可以等同于i-1处字符的真值
                // 再或者就是这个*号前面又是个.号，这样的话也可以等于i-1处字符的真值，毕竟.*随意匹配
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2] || // *表示空串
                               (p.charAt(j-2) == s.charAt(i-1) || // *表示单个字符或为.
                               p.charAt(j-2) == '.') && dp[i-1][j]; // 这时候就可以跟上个字符的真值等同
                } else {
                    // 只要不是*，那就必须当前字符是一致的，或者RegExp的这个位置是个.号，这样就可以复用dp[i-1][j-1]的真值
                    dp[i][j] = (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) && dp[i-1][j-1];
                }
            }
        }
        return dp[strLen][patrLen];
    }
}
