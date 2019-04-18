package lc006;

import java.util.Arrays;

/**
 * 发现了zig zag的规律其实不难，就是维护一个方向变量，向下的时候填满当前列，向上的时候，每移动一次向右移动一格即可
 */
public class Solution006 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2) return s;
        char[] strArr = s.toCharArray();
        int cols = (s.length()/((numRows-1)*2))*(numRows-1)+1;
        char[][] matrix = new char[numRows][cols];
        for (char[] chars : matrix) Arrays.fill(chars, '@');
        boolean downstairs = true;
        int index = 0;
        int left = 0;
        int top = 0;
        while (index < strArr.length) {
            if (downstairs) {
                matrix[top++][left] = strArr[index++];
            } else {
                matrix[top--][left++] = strArr[index++];
            }
            if (top == numRows-1) {
                downstairs = false;
            } else if (top == 0) {
                downstairs = true;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '@') builder.append(matrix[i][j]);
            }
        }
        return builder.toString();
    }
}
