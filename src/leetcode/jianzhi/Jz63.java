package jianzhi;

import java.util.Collections;
import java.util.PriorityQueue;

public class Jz63 {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    public void Insert(Integer num) {
        max.offer(num);
        min.offer(max.poll());
        // max永远比min多一个或者相等，在总数为奇数或偶数时
        if (min.size() > max.size()) max.offer(min.poll());
    }

    public Double GetMedian() {
        if (min.size() == max.size()) return (min.peek() + max.peek()) / 2.0;
        else return Double.valueOf(max.peek());
    }
}
