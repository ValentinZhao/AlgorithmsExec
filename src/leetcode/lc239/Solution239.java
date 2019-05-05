package lc239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 逻辑十分直截了当
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            while (!queue.isEmpty() && queue.peek() < i - k + 1) queue.poll();
            // remove smaller numbers in k range as they are useless
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast();
            // q contains index... r contains content
            queue.offer(i);
            if (i > k - 1) res[ri++] = nums[queue.peek()];
        }
        return res;
    }
}
