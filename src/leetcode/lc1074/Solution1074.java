package lc1074;

import java.util.HashMap;
import java.util.Map;

public class Solution1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = i; j < col; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                int curSum = 0;
                map.put(0, 1);
                for (int k = 0; k < row; k++) {
                    curSum += matrix[k][j] - (i > 0 ? matrix[k][i-1] : 0);
                    res += map.getOrDefault(curSum - target, 0);
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return res;
    }
}
