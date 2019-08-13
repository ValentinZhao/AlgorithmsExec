package lc056;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 **/

public class Solution056 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty() || intervals.size() == 1) return intervals;
        LinkedList<Interval> store = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(i -> i.start));
        // 在遍历的时候记住一点就是，需要合并的这一步，是不需要推入集合中的，这一步只需要更新start和end
        // 同时，如果判断发现这步不需要merge，在else中我们依然把当前interval推入集合，这就是巧妙的地方了
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) { // need to merge
                end = Math.max(end, interval.end);
            } else {
                store.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        store.add(new Interval(start, end));
        return store;
    }
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}

class Solution {
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