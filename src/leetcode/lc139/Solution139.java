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

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l = wordDict.size();
        boolean [] dp = new boolean[l+1];
        dp[0] = true;
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    // 那么由于dp[j]是true，它说明前j个字符组成的字母可以被找到了
                    // 同时j到i的这段字母也可以被找到，证明从0到i都是可以被找到的
                    // 那么就直接把dp[i]给到true，然后退出循环，因为不用再找了
                    // 我们找的这个j其实就是找一个合适的位置，从它断开的两个词都可以在dict中找到
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[l];
    }
}