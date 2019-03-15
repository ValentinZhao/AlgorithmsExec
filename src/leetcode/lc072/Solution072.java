package lc072;

/**
 * 非常经典的二维DP题，难度当然为Hard。我们设定的dp[i,j]含义为，从word1的前i个字母转换为word2的前j个字母所需的步骤数，非常巧妙的方程
 * 状态转移方程共有两种状态:
 * 1. 一种是word1[i] == words[j]，那么这个时候在这一步dp我们不需要做任何事，那就意味着这步dp和上一步dp的状态是一样的，即dp[i][j] == dp[i-1][j-1]
 * 2. 不相等的时候，我们有三种操作，这步dp的结果肯定是这三个步骤中cost lowest的那个，那么问题在于如何表达这三种操作
 * 插入的话，我们会保证word1插入的字母跟word2的j位置的字母一致，那么我们在什么情况下会使用插入操作？当然是**word1前i个字母和word2前j-1个字母都一致的时候**
 * 这时候我们才会想在word1的i位置插入一个字母使其和word2的j字母相等，这样才满足了前i和前j个字母组成的子串是相等的，即 dp[i][j]=dp[i][j-1] + 1 (加上本身这一步)
 * 删除也是一样的symmetric操作，我们在word1的前i-1个字母都和word2前j个字母相等的情况下，唯独多出了一个word1[i]，当然是要删掉它, 即 dp[i][j]=dp[i-1][j] + 1
 * 替换同理，我们在这一步只是换了个字母，两个字符串长度都没变，说明除了word1[i]和word2[j]其他都相等，那就是等于 dp[i][j]=dp[i-1][j-1] + 1
 * 取这三者最小值即可。
 * 最后是起始状态，一般基础条件就是当元素起始时的状态，即dp[0]是多少。那么此题我们知道dp[0][K]=dp[K][0]=K，其实就是空串匹配非空串只要增加/删减K步即可
 */
public class Solution072 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        return dp[m][n];
    }
}
