package lc759;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach((a) -> pq.addAll(a));
        Interval temp = pq.poll();
        while (!pq.isEmpty()) {
            if (temp.end < pq.peek().start) {
                res.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll();
            } else {
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return res;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start,int _end) {
            start = _start;
            end = _end;
        }
    };
}
