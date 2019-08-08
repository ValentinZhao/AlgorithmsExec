package lc200;

public class Solution200 {
    private int row = 0;
    private int col = 0;
    private int count = 0;
    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row <= 0) return 0;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    checkIslandDFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void checkIslandDFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        checkIslandDFS(grid, i + 1, j);
        checkIslandDFS(grid, i - 1, j);
        checkIslandDFS(grid, i, j + 1);
        checkIslandDFS(grid, i, j - 1);
    }
}