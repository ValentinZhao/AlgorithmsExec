package lc059;

/**
 * 具体的spiral读取算法请看lc054，那么作为054的变种，读取算法不变，我们只需要记录下所有的坐标，把坐标给到二维数组
 * 同时填入数字即可
 */
public class Solution059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 0;
        while (count < n * n) {
            // 在循环判断条件里面加count<n*n是为了填完数字之后停止循环，避免数组越界
            for (int i = left; i <= right && count < n*n; i++) res[top][i] = ++count;
            for (int i = top + 1; i < bottom && count < n*n; i++) res[i][right] = ++count;
            for (int i = right; i >= left && count < n*n; i--) res[bottom][i] = ++count;
            for (int i = bottom - 1; i > top && count < n*n; i--) res[i][left] = ++count;
            left++;right--;top++;bottom--;
        }
        return res;
    }
}
