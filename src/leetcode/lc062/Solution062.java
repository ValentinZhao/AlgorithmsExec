package lc062;

/**
 * 第一版走格子就很简单，只允许向右或向下走，这样当我们横向增加或竖向增加的时候，i.e,2x2的grid，横向增加一列变为3x2，这样根据上一个状态
 * 再走到右下角只需要一种移动方式；那么竖向增加一行变为2x3的grid也是只有一种走法到右下角
 */
public class Solution062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
