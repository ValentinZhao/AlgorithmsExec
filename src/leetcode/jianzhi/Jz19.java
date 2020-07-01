package jianzhi;

import java.util.ArrayList;

public class Jz19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < total) {
            for (int i = left; i <= right && list.size() < total; i++) list.add(matrix[top][i]);
            for (int i = top+1; i < bottom && list.size() < total; i++) list.add(matrix[i][right]);
            for (int i = right; i >= left && list.size() < total; i--) list.add(matrix[bottom][i]);
            for (int i = bottom-1; i > top && list.size() < total; i--) list.add(matrix[i][left]);
            left++;right--;top++;bottom--;
        }

        return list;
    }
}
