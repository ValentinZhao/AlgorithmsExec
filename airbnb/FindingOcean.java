class Solution {
    public static int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void floodFill(char[][] board, int i, int j, char oldColor, char newColor) {
         if (board[i][j] != oldColor || board[i][j] == newColor) {
                return;
        }
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i ,j});
        board[i][j] = newColor;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int[] dir : dirs) {
                inx curX = dir[0] + pos[0];
                int curY = dir[1] + pos[1];
                if (curX < 0 || curX >= row ||
                    curY < 0 || curY >= col ||
                    board[curX][curY] != oldColor) continue;
                board[curX][curY] = newColor;
                queue.offer(new int[]{curX, curY});
            }
        }
    }
}