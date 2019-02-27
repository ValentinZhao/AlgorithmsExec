package lc295;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 使用最大最小堆来维护两个数据结构，一个是保存median左边较小的数组，这个数组保存在**最大堆**里面，用来返回left median
 * 同理最小堆返回right median，同时尽量保持两个堆是平衡的，这样当两个堆数量一致，则median是算术平均数；如果不一致则返回最大堆堆顶，因为它是较小的数组
 */
public class Solution295 {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public Solution295() {
        min = new PriorityQueue<>(); // 最小堆但维护较大的一半数组
        max = new PriorityQueue<>(Collections.reverseOrder()); // vice versa
    }
    
    public void addNum(int num) {
        // 这部分就很巧妙，大顶堆小顶堆其实会自己帮我们排序
        // 大顶堆每次会把max推给小顶堆，当元素个数大于1的时候其实就是自然排序好的
        // 同理小东对往回推的时候自己也是排序好的，同时那个值是最小的，这个"最小值"到了大顶堆变成最大值，同时出发重新排序
        // 这也就是为什么大顶堆变成较小的一半，小顶堆变成较大的一半
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) max.offer(min.poll());
    }
    
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        return max.peek();
    }
}
