package lc115;

/**
 * https://leetcode.com/problems/distinct-subsequences/discuss/37387/A-DP-solution-with-clarification-and-explanation
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int sl = sArray.length;
        int tl = tArray.length;
        int[][] dp = new int[tl+1][sl+1];
        for (int i = 0; i < sl; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= tl; i++) {
            for (int j = 1; j <= sl; j++) {
                if (tArray[i-1] != sArray[j-1]) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }
        return dp[tl][sl];
    }
}
