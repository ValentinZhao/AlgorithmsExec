package alibaba;

/**
 * 基本上和最长子序列思路一致，两个字符相等就在上一个dp的基础上+1
 * 不同点在于，最长子序列在遇到不同字符时，会选择上一个状态的较大值，毕竟不需要连续
 * 但最长子串的话，需要连续，一旦出现字符串不一样长就会直接归零
 */
public class LongestCommonString {
    public static int getLCS(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxValue = Math.max(maxValue, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }
        return maxValue;
    }
}
