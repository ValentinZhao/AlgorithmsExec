package alibaba;

/**
 * Math.min问题是经典的动态规划，我们使用二维数组，dp[i][j]表示i长度的字符串1和j长度的字符串2的LCS是多长
 * 我们自底向上,dp[0][0]一定是0，然后用嵌套循环更新dp值。转移方程为，如果i和j上面字符是一致的，那么直接等于dp[i-1][j-1]+1
 * 如果不相等，我们要取max(dp[i-1][j], dp[i][j-1])
 */
public class LongestCommonSequence {
    public static int getLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                // 这里使用i-1和j-1比较的目的是因为数组从零开始，i-1和j-1相等才能决定dp[i][j]的状态
                else if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(getLCS("AGGTAB", "GXTXAYB"));
    }
}
