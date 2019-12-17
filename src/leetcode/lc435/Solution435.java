package lc435;

import java.util.Arrays;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int count = 1;
        int end = intervals[0][1];

        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
