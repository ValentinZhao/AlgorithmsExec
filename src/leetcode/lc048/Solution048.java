package lc048;

/**
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 */

/**
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
 */
public class Solution048 {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                // **注意！！**这里的话，col是从row开始的，这样我们就知道，每次symmetric变换的时候，起始点总是对角线上的点
                // 比如(0,0),(1,1), (2,2)，这样就保证只遍历了矩阵上半区，然后进行替换即可；如果col也从0开始，那么上半区换完之后又会走下半区
                // 把换过的数字**又换了回来**！！所以整体是不变的；故我们只遍历上半区，也就是每个nested loop都从对角线开始
                if (i == j) continue;
                else {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

}
