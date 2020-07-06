package jianzhi;

public class Jz52 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int m = str.length, n = str.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            // 初始化第一列时，当前regexp读到了*，同时前面的regexp可以匹配
            // 那么我们认为可以跳过这个*，认为i+2位置以前的都可以匹配
            if (pattern[i] == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 以下两种情况下，s和p可以直接同时进一位，因为这一位完全匹配
                if (pattern[j] == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (pattern[j] == str[i]) {
                    dp[i+1][j+1] = dp[i][j];
                }
                // 当当前regexp是*的话，情况分两种
                if (pattern[j] == '*') {
                    if (pattern[j-1] != str[i] && pattern[j-1] != '.') {
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
