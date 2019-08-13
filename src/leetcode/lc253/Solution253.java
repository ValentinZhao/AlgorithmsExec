package lc253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解题思路就是，首先最核心的一点要不要申请新的会议室，就是判断一个时间段的结束时间和另外一个时间段的开始时间，如果前一个结束和后一个开始是相等或者小于的关系
 * 这说明这两个时间段是能连在一起的，也就是说不需要新的会议室了；vice versa。然后我们用最小堆来维护一个以"结束时间"为标准的时间段的容器，也就是说每次poll
 * 的时候都会返回结束时间最早的那个时间段，这样就方便我们比较。我们同时也维护着一个按开始时间升序的数组，这样，我们就可以迭代遍历数组，比较下个元素的开始时间
 * 和当前元素的结束时间来判断是否要把下个时间段加入最小堆中。因为如果后一个开始时间在前一个结束时间之前，那就得新申请一个了，把后面这个加入最小堆，循环结束一轮再poll的话
 * 有可能就是返回刚加入的这个时间段如果它结束时间更早的话。总之最小堆是很巧妙的，他能保证总给你提供一个结束时间较早的一个时间段，尽量使得会议室占用最低
 */
public class Solution253 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = pq.poll();
            if (cur.end <= intervals[i].start) pq.offer(intervals[i]);
            else {
                pq.offer(cur);
                pq.offer(intervals[i]);
            }
        }
        return pq.size();
    }

    private class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}

class Solution {
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