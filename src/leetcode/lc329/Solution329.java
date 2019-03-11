package lc329;

/**
 * 其实跟max island一样的思路，四个方向dfs，但是有一个递增的需求，就是下一位必须比现在这位大，加上这个限制即可
 */
public class Solution329 {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] cache = new int[row][col];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int len = dfs(matrix, i, j, row, col, cache);
                max = Math.max(len, max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int row, int col, int[][] cache) {
        // 因为每个位置势必要被访问多次，所以做一个cache增大效率
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= row || y < 0 || y >= col || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, row, col, cache);
            max = Math.max(len, max);
        }
        cache[i][j] = max;
        return max;
    }
}
