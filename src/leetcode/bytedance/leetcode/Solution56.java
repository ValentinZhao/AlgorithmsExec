package bytedance.leetcode;

import java.util.Arrays;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int[][] res = new int[intervals.length][2];
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
