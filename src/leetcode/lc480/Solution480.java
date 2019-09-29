package lc480;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution480 {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length - k + 1; // 遍历到这个位置也就遍历完了，因为我们是移动sliding window

        if (n <= 0) return new double[0];

        double[] results = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                remove(nums[i-k]);
                results[i-k] = getMedian();
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        return results;
    }

    private double getMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) return 0;
        if (minHeap.size() == maxHeap.size()) {
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2.0;
        } else return (double)minHeap.peek();
    }

    private void add(int num) {
        if (num < getMedian()) maxHeap.offer(num);
        else minHeap.offer(num);

        if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
        if (minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());
    }

    private void remove(int num) {
        if (num < getMedian()) maxHeap.remove(num);
        else minHeap.remove(num);

        if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
        if (minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());
    }
}
