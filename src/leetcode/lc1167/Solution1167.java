package lc1167;

import java.util.PriorityQueue;

public class Solution1167 {
//    public int connectSticks(int[] sticks) {
//        int n = sticks.length;
//        Arrays.sort(sticks);
//        int[] dp = new int[n];
//        dp[0] = sticks[0];
//
//        for (int i = 1; i < n; i++) {
//            dp[i] = dp[i-1] + sticks[i];
//        }
//
//        int minimum = 0;
//        for (int i = 1; i < n; i++) {
//            minimum += dp[i];
//        }
//
//        return minimum;
//    }

    // 上面方法是有问题的，就算你先排序过，后面数字很大的时候，前面的累和也会远大于后面的数字
    // 这时候正确的策略是把最大的数字不断扔在数组后面，只加最小的，这不就是greedy的做法么
    // 实现就用heap即可
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) {
            pq.offer(s);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int two = pq.poll() + pq.poll();
            sum += two;
            pq.offer(two);
        }
        return sum;
    }
}
