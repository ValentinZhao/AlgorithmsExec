package lc073;

/**
 * 这题走远了，问题是在matrix里面，遇到0就把0所在的整行整列都置为0，那么这样其实只需要映射到一行一列即可，因为比如说一行里面有两个0
 * 这时候遇到第一个0的时候就已经可以把整行都置为0了，列也一样，只要第一次遇到的0这列就都是0
 * 所以我们只需要两个数组，用来记录这行这列有没有出现过0即可
 * 最后重新遍历matrix，对应i,j，只要找数组row和col的i,j是否是记录有0出现过即可，只要遍历到的这个点，它的行或列有记录过出现过0，那就置0
 */
public class Solution073 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
