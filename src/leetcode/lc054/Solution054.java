package lc054;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路，主要就是找到一个正确的spiral算法，我们采用的读取方式如下：假设5x6的一个matrix
 * >>>>>
 * |>>>|
 * ||>||
 * ||<||
 * |<<<|
 * <<<<<
 * 这样的顺序来完成，它的特点总结来说就是横向的头尾读完，纵向的总是把循环上抬/下沉一位再开始的一个顺时针的走向
 */
public class Solution054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int col = matrix[0].length, row = matrix.length;
        int left = 0, up = 0, right = col - 1, bottom = row - 1;
        while (list.size() < col * row) {
            for (int i = left; i <= right && list.size() < col * row; i++)
                list.add(matrix[up][i]);
            for (int j = up + 1; j < bottom && list.size() < col * row; j++)
                list.add(matrix[j][right]);
            for (int i = right; i >= left && list.size() < col * row; i--)
                list.add(matrix[bottom][i]);
            for (int j = bottom - 1; j > up && list.size() < col * row; j--)
                list.add(matrix[j][left]);
            left++; up++; right--; bottom--;
        }
        return list;
    }
}