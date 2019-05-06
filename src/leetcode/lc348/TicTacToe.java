package lc348;

/**
 * 没要必要记录n*n棋坛的所有情况，我们只需要维护两个一位数组，一个记录行被下了几次棋，一个记录列
 * 只要有一行或一列被计数为n，我们就知道这行或者列被下满了，就可以获胜
 * 还有种情况是对角线和反对角线
 */
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        int size = rows.length;
        if (row == col) diagonal += toAdd;
        if (col == (cols.length - row - 1)) antiDiagonal += toAdd;
        if (    Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antiDiagonal) == size) return player;
        return 0;
    }
}
