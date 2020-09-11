package yuanfudao;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solve(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtracking(board, res, 0, n);
        return res;
    }

    private void backtracking(char[][] board, List<List<String>> res, int row, int n) {
        if (row == n) {
            res.add(buildChessboard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtracking(board, res, row+1, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = row-1; i >= 0 ; i--) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row-1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row-1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> buildChessboard(char[][] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            list.add(new String(queens[i]));
        }
        return list;
    }

}
