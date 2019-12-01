package lc980;

public class Solution980 {
    int tr, tc;
    int rows, cols;
    int res;
    private static int[][] dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int emptyRoomLeft = 0; // 就是用这个来计算是否所有房间都去过了
        int sr = 0, sc = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != -1) emptyRoomLeft++;
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    tr = i;
                    tc = j;
                }
            }
        }
        res = 0;
        backtracking(grid, sr, sc, emptyRoomLeft);
        return res;
    }

    private void backtracking(int[][] grid, int sr, int sc, int emptyRoomLeft) {
        --emptyRoomLeft;
        if (emptyRoomLeft < 0) return;
        if (sr == tr && sc == tc) {
            if (emptyRoomLeft == 0) res++;
            return;
        }

        grid[sr][sc] = 3;

        for (int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                if (grid[r][c] % 2 == 0) {
                    backtracking(grid, r, c, emptyRoomLeft);
                }
            }
        }

        grid[sr][sc] = 0;

    }
}
