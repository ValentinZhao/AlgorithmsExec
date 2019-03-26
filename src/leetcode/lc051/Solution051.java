package lc051;

import java.util.ArrayList;
import java.util.List;

public class Solution051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] queens = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queens[i][j] = '.';
            }
        }
        backtracking(res, queens,0, n);
        return res;
    }

    private void backtracking(List<List<String>> res, char[][] queens, int row, int n) {
        if (row == n) {
            res.add(buildChessboard(queens));
            return;
        }
        for (int col = 0; col < n; col++) {
            // 当找到一个合适的位置的时候，我们把这个点设为Q并且从这个点开始新的回溯，回溯之后（产生了新的结果）
            // 我们再把该点设置回'.'，然后进入之前的循环继续遍历列
            if (isValid(queens, row, col)) {
                queens[row][col] = 'Q';
                backtracking(res, queens, row + 1, n);
                queens[row][col] = '.';
            }
        }
    }

    /**
     * 只需要判断这个点的上面的部分即可，因为下面的部分由于还未构建所以肯定啥也没有，
     * 要判断的就是正上方，西北45度和东北135度这三个方向有无Queen
     * @param queens
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(char[][] queens, int row, int col) {
        for (int i = row; i >= 0; i--) {
            if (queens[row][col] == 'Q') return false;
        }
        // northwestern 45 degree
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (queens[row][col] == 'Q') return false;
        }
        // northeastern 135 degree
        for (int i = row - 1, j = col + 1; i >= 0 && j < queens[0].length; i--, j++) {
            if (queens[row][col] == 'Q') return false;
        }
        return false;
    }

    private List<String> buildChessboard(char[][] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            list.add(new String(queens[i]));
        }
        return list;
    }
}
