package lc289;

/**
 * lives代表周围可允许存活的人口城镇数量，巧妙的点在于
 * 0 - dead, 1 - live, 2 - go die, 3 - will live
 * 这样最后直接用mod 2就可以完整处理回数据，实现in-place处理的follow-up了
 */
public class Solution289 {
    public void gameOfLife(int[][] board) {
        int[][] dirs = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        int col = board[0].length, row = board.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = 0;
                for (int[] dir : dirs) {
                    if (dir[0] + i < 0 || dir[0] + i > row || dir[1] + j < 0 || dir[1] + j > col) continue;
                    if (board[dir[0] + i][dir[1] + j] == 1 || board[dir[0] + i][dir[1] + j] == 2) lives++;
                }
                if (board[row][col] == 0 && lives == 3) board[row][col] = 3;
                if (board[row][col] == 1 && (lives < 2 || lives > 3)) board[row][col] = 2; 
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[row][col] %= 2;
            }
        }
    }
}
