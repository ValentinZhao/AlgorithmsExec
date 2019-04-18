package lc074;

/**
 * 解决这类题型（关联lc240），只要记住一点就迅速破题，就是"从右上角开始找"
 */
public class Solution074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length-1) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
