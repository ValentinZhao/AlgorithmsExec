package lc348;

public class Solution348 {
    class TicTacToe {
        private int[] rows;
        private int[] cols;
        private int diagnol;
        private int antiDiagnol;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            diagnol = 0;
            antiDiagnol = 0;
        }

        public int move(int row, int col, int player) {
            int increment = player == 1 ? 1 : -1;
            rows[row] += increment;
            cols[col] += increment;

            if (row == col) diagnol += increment;
            int size = rows.length;
            if ((col + row) == (cols.length - 1)) antiDiagnol += increment;

            if (    Math.abs(rows[row]) == size ||
                    Math.abs(cols[col]) == size ||
                    Math.abs(diagnol) == size ||
                    Math.abs(antiDiagnol) == size) return player;
            return 0;
        }
    }

}
