package lc378;

/**
 * lo和hi就是matrix里面的元素
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int col = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (col >= 0 && matrix[i][col] > mid) col--;
                count += (col + 1);
            }
            // 小于k的话，说明matrix[i][col]一直大于mid，因为i本身是遍历行，前面遍历的时候就已经比mid大了
            // 这说明整个matrix展开的数组就可能就是前面小后面大的结构，这时候要二分查找当然要把lo往前推
            // 这说明k可能落在后半部，这时候就要把lo抬起来
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int col = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (col >= 0 && matrix[i][col] > mid) col--;
                count += (col + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}