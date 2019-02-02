package lc139;

import java.util.List;

/**
 * DP题，目的在于从最小子串开始比起，把所有i和其之前的子串都和dict比过
 * 如果这个i的所有子串都不能匹配dict，它在下一个循环的dp[i]的时候会由于是false跳过这一位的所有遍历，j直接跳向i+1
 * 如果i匹配了dict就会使这一位变为true，成为下一个问题的子问题最优解，直到i变为字符串长度，这个时候如果dp[i]是true的话
 * 就可以证明字符串存在dict的匹配项，反之亦然，所以最后直接返回dp[length]即可
 */
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        boolean[] dp = new boolean[l + 1];
        dp[0] = true;
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[l];
    }
}
