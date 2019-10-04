package lc037;

public class Solution037 {
    public void solveSudoku(char[][] board) {
        buildSudoku(board, 0, 0);
    }

    private boolean buildSudoku(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValidSudoku(board, i, j, k)) {
                        board[i][j] = k;
                        if (buildSudoku(board, i, j+1)) return true;
                        board[i][j] = '.';
                    }
                }
                // after checking all 9 digits and you cannot find a valid digit, just return false on this position
                return false;
            }
        }
        // at the bottom of recurrsion, row and col could be just 8 and loop would over instantly
        // and in this scenario just return true, since empty board is valid
        return true;
    }

    /**
     * check out valid sudoku problem for better explanation on why row / 3
     */
    private boolean isValidSudoku(char[][] board, int row, int col, int target) {
        // 通过除3得到了这个3x3block的坐标，9个区域的81个格子，通过除3，最后在一个区域的坐标都会得到同样的一个坐标，这就是收缩
        // 也就是block的坐标
        int blkRow = (row / 3) * 3, blkCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == target ||
                board[row][i] == target ||
                    /**
                     * 这个部分很巧妙，你使用i=0~8试试就知道，可以在3x3board中产生
                     * (0,0) ~ (2,2)的顺序坐标，用这个办法检查自己的3x3board中有没有出现过待检测的target
                     */
                board[blkRow + i / 3][blkCol + i % 3] == target)
                return false;
        }
        return true;
    }
}
