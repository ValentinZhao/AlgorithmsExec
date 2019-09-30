package lc632;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 这道题是让你找同时包括这几个list中至少一个元素的最小range
 */
public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        /**
         * 这里的int[]的格式为, [某个list中的某个元素, 该数字所在的list在nums中的index, 该数字在原list中的index]
         */
        int max = nums.get(0).get(0);
        // 把每个list第一个元素做一个小数组，怼到pq里
        // 这个max就厉害了，它代表当前出现的最大元素，厉害在哪呢？有两方面
        // 一方面，我们后面取最小range，都是靠这个max和出队的元素作差来比较的
        // 如果能取到后面更小的range就更新，取不到就是一直保持原状
        // 这个max其实就相当于一个cursor在k个list之间游走
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        int minRange = Integer.MAX_VALUE;
        int start = -1;
        // 这里这样的设计，是一定可以走完全部list的全部元素的，为什么呢
        // 因为所有int[]都会在最后把自己的下一位推进pq，这保证了pq的size一直是k
        // 遍历到最后才会说没有下一位了无法推入，那这时候已经遍历结束了
        while (pq.size() == nums.size()) {
            int[] curr = pq.poll();

            if (max - curr[0] < minRange) {
                minRange = max - curr[0];
                start = curr[0];
            }

            // 当取到的这个值，还是在他所在list里面的时候(并且不是最后一位)
            if (curr[2] + 1 < nums.get(curr[1]).size()) {
                // 我们把它后面一个值给塞进去
                curr[2]++;
                curr[0] = nums.get(curr[1]).get(curr[2]);
                pq.offer(curr);
                // max这里就厉害了，他保证了自己总是k个list中的某个元素，然后再扩大
                // 这就能保证说最后得到的range里面是可以同时包括来自所有list中的某些元素
                max = Math.max(max, curr[0]);
            }
        }
        return new int[]{start, start + minRange};
    }
}
