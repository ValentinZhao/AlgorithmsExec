package lc097;

public class Solution097 {
    // brute force, TLE. Could be a nice one after adding memo to cache results.
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleaveDFS(s1, 0, s2, 0, s3, "");
    }

    private boolean isInterleaveDFS(String s1, int i, String s2, int j, String s3, String res) {
        if (res.equals(s3) && s1.length() == i && s2.length() == j) return true;
        boolean ans = false;
        if (s1.length() > i) ans |= isInterleaveDFS(s1, i+1, s2, j, s3, res+s1.charAt(i));
        if (s2.length() > j) ans |= isInterleaveDFS(s1, i, s2, j+1, s3, res+s2.charAt(j));
        return ans;
    }

    // DP solution. Very clean one.
    // dp[i][j] means when s1 arrives i, s2 arrives j and s3 arrives i+j-1 if they are equal.
    // rule is when i equals to 0 then every s2 letters should be equal to s3, also applicable to s2
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = dp[i][j-1] && s2.charAt(j) == s3.charAt(i+j-1);
                else if (j == 0) dp[i][j] = dp[i-1][j] && s1.charAt(i) == s3.charAt(i+j-1);
                else dp[i][j] = (dp[i][j-1] && s2.charAt(j) == s3.charAt(i+j-1)) ||
                                (dp[i-1][j] && s1.charAt(i) == s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
