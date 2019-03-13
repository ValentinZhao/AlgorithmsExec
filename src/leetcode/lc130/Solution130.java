package lc130;

/**
 * 这题的话，我们只需要做的就是把边框上的O和与之相连的所有O用DFS变为第三种图形，比如说@，这时候我们就可以说剩下的所有O都是在边框内
 * 并且被X所包裹，最后把这些O变为X，再把@恢复为O即可
 *
 *          X X X X           X X X X             X X X X
 *          X X O X  ->       X X O X    ->       X X X X
 *          X O X X           X @ X X             X O X X
 *          X O X X           X @ X X             X O X X
 */
public class Solution130 {
    public static int[][] dirs = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < col; i++) {
            if (board[0][i] == '0') checkDFS(board, 0, i, row, col);
            if (board[row-1][i] == '0') checkDFS(board, row-1, i, row, col);
        }
        for (int i = 1; i < row-1; i++) {
            if (board[i][0] == '0') checkDFS(board, i, 0, row, col);
            if (board[i][col-1] == '0') checkDFS(board, i, col-1, row, col);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                board[i][j] = c == 'O' ? 'X' : c == '@' ? 'O' : 'X';
            }
        }
    }

    private void checkDFS(char[][] board, int i, int j, int row, int col) {
        board[i][j] = '@';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != '0') continue;
            checkDFS(board, x, y, row, col);
        }
    }
}
