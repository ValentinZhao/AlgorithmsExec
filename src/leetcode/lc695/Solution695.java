package lc695;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea  = 0;
        for (int i = 0; i < grid.length; i++) for (int j = 0; j < grid[0].length; j++) if (grid[i][j] == 1) maxArea = Math.max(maxArea, detectMaxAreaDFS(grid, i, j));
        return maxArea;
    }

    public int detectMaxAreaDFS(int[][] grid, int row, int col) {
        if (col >= 0 && col < grid[0].length && row >= 0 && row < grid.length && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + detectMaxAreaDFS(grid, row - 1, col) + detectMaxAreaDFS(grid, row + 1, col) + detectMaxAreaDFS(grid, row, col - 1) +detectMaxAreaDFS(grid, row, col + 1);
        }
        return 0;
    }
}