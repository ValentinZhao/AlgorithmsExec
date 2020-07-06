package lc010;

/**
 * 用二维DP数组来维护一个布尔表，dp[i][j]代表匹配到该位置的真假
 * 二维数组的行代表原始字符串，按照每一个字符一位
 * 列代表RegExp字符串，每个字符一位
 *
 * https://blog.csdn.net/hk2291976/article/details/51165010
 */

// 这个跑不过
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

/**
 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
 * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
 * 3, If p.charAt(j) == '*':
 *    here are two sub conditions:
 *                1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
 *                2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
 *                               dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
 *                            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
 *                            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            // 初始化第一列时，当前regexp读到了*，同时前面的regexp可以匹配
            // 那么我们认为可以跳过这个*，认为i+2位置以前的都可以匹配
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 以下两种情况下，s和p可以直接同时进一位，因为这一位完全匹配
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                // 当当前regexp是*的话，情况分两种
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1]; // 跳过整个a*
                    } else {
                        dp[i+1][j+1] = dp[i][j+1] || // 这情况我们发现s不需要向前匹配，只有p向前了，它表示a*代表了aa，即*表示多个字符
                                       dp[i+1][j] || // 这情况是a*只表示一个a，那么此时所求dp只需要匹配上一个regexp即可
                                       dp[i+1][j-1]; // 它表示匹配到了.*，这样的话它可以是任何值，只需要直接和两个字符前的regexp相同即可
                    }
                }
            }
        }
        return dp[m][n];
    }
}