package lc079;

public class Solution079 {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 在board里面nest loop来找一个正确的起点
                if (wordExistDFS(board, i, j, letters, 0)) return true;
            }
        }
        return false;
    }

    private boolean wordExistDFS(char[][] board, int row, int col, char[] letters, int lengthHasRead) {
        if (lengthHasRead == letters.length) return true; // 读到最后，DFS深度和原单词长度都相等了，就肯定一致了，返回true
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) return false;
        if (board[row][col] != letters[lengthHasRead]) return false;
        // 每一个visited过的点都要变掉，XOR 256的目的是，256是能够将所有char类型的字符完整转码的长度；如果不变掉，DFS向上（向来的方向）的时候又会重读，是不对的
        board[row][col] ^= 256;
        boolean isExist =
                wordExistDFS(board, row + 1, col, letters, lengthHasRead + 1) ||
                wordExistDFS(board, row - 1, col, letters, lengthHasRead + 1) ||
                wordExistDFS(board, row, col + 1, letters, lengthHasRead + 1) ||
                wordExistDFS(board, row, col - 1, letters, lengthHasRead + 1);
        board[row][col] ^= 256;
        return isExist;
    }
}
