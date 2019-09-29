package lc304;

public class Solution304 {
    class NumMatrix {
        private int[][] dp;
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int m = matrix.length, n = matrix[0].length;
            dp = new int[m+1][n+1];
            // 由于dp是整个扩大了一圈，所以dp数组的意思为
            // dp[i][j]是，原matrix[i-1][j-1]到左上角原点的全部元素的和
            // 每个dp计算的理由，画个图就知道了，基本就是重叠区域去重+本身
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 和上面dp公式差不多，从dp求一块区域的和的话，我们就通过从全部dp中抠出那些在边界之外的部分
            // 再加上重复抠出的部分即可
            return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
        }
    }

}