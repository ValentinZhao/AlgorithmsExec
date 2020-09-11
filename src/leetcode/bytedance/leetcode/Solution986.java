package bytedance.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int maxStart = 0, minEnd = 0;
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            maxStart = Math.max(A[i][0], B[j][0]);
            minEnd = Math.min(A[i][1], B[j][1]);

            if (maxStart <= minEnd) {
                res.add(new int[]{maxStart, minEnd});
            }

            if (minEnd == A[i][1]) i++;
            if (minEnd == B[j][1]) j++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
