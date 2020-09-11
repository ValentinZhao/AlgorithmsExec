package kwai;

import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[intervals.length][2];
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res[i] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        return res;
    }
}
