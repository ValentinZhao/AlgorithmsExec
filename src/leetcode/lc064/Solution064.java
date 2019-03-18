package lc064;

/**
 * 依然利用DP解法，先初始化一行一列，使得他们是从上到下从左往右依次累加的
 * 接下来对待里面的所有值都遵循do转移方程
 * grid[m][n]=min(grid[m-1][n],grid[m][n-1])+grid[m][n]
 */
public class Solution064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j-1];
                else if (j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
