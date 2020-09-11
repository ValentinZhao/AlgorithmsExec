package kwai;

import java.util.ArrayList;
import java.util.List;

public class Solution986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return new int[][]{};
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int startMax = Math.max(A[i][0], B[j][0]);
            int endMin = Math.min(A[i][1], B[j][1]);

            if (startMax <= endMin) {
                list.add(new int[]{startMax, endMin});
            }

            if (A[i][1] == endMin) i++;
            if (B[j][1] == endMin) j++;
        }

        return list.toArray(new int[list.size()][2]);
    }

    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return new int[][]{};
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int startMax = Math.max(A[i][0], B[j][0]);
            int endMin = Math.min(A[i][1], B[j][1]);

            if (startMax <= endMin) res.add(new int[]{startMax, endMin});

            if (A[i][1] == endMin) i++;
            if (B[j][1] == endMin) j++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
