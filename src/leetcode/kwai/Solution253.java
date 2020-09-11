package kwai;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = pq.poll();
            if (curr[1] <= intervals[i][0]) {
                pq.offer(intervals[i]);
            } else {
                pq.offer(curr);
                pq.offer(intervals[i]);
            }
        }
        return pq.size();
    }
}
