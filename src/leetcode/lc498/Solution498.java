package lc498;

/**
 * 就是一道找规律题，一共两个方向四条定律，看一下图就知道了
 * 1. 当你的横纵坐标之和为奇数时，你的方向是朝下的，偶数vice versa
 * 2. 向上时，遇到top border，就向右移一格
 * 3. 向上时，遇到right border，就向下移一格；其余情况斜向上
 * 4. 向下时，遇到bottom border，就向右移一格
 * 5. 向下时，遇到left border，就向下移一格；其余情况斜向下
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if      (c == n - 1) { r++; }
                else if (r == 0)     { c++; }
                else            { r--; c++; }
            } else {                // moving down
                if      (r == m - 1) { c++; }
                else if (c == 0)     { r++; }
                else            { r++; c--; }
            }
        }
        return arr;
    }
}
