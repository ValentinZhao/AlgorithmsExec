package lc733;

public class Solution733 {
    private static int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        int currColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        floodFillDFS(image, sr, sc, currColor);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (image[i][j] == -1) image[i][j] = newColor;
            }
        }
        return image;
    }

    private void floodFillDFS(int[][] image, int row, int col, int currColor) {
        for (int[] dir : dirs) {
            int curRow = dir[0] + row;
            int curCol = dir[1] + col;
            if (curRow < 0 || curRow >= image.length || curCol < 0 || curCol >= image[0].length ||
            image[curRow][curCol] != currColor || image[curRow][curCol] < 0) continue;
            image[row][col] = -1;
            floodFillDFS(image, curRow, curCol, currColor);
        }
    }
}
