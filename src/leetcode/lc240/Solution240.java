package lc240;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // testcases: [], [[]]
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int lo = 0, hi = row, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] > target) {
                hi = mid;
            } else if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else if (matrix[mid][0] == target) return true;
        }
        // 这里有可能是在第一行，如果不=0的话就会少检查一行
        while (mid >= 0) {
            lo = 0;
            hi = col;
            while (lo < hi) {
                int n_mid = lo + (hi - lo) / 2;
                if (matrix[mid][n_mid] > target) {
                    hi = n_mid;
                } else if (matrix[mid][n_mid] < target) {
                    lo = n_mid + 1;
                } else if (matrix[mid][n_mid] == target) return true;
            }
            mid--;
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        // 最重要的就是记得从**右上角**开始遍历
        int row = 0, col = matrix[0].length-1;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}