package lc1094;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 还是一道和meeting rooms II非常像的一道题，intuition是
 * 我们首先把所有人的travel按照start time来排序，毕竟我们只能向右开，所以肯定要按照开始顺序尽量的把人接到车上
 * 我们遍历这个travel list，然后维护一个以end time排序的pq，这样我们遍历到下一个travel时，都去和pq.peek比较
 * 毕竟如果我们当前的travel的开始时间大于pq.peek的结束时间，证明pq中的travel已经结束了，要把他推出
 *
 * 最后就是要注意每次遍历的时候，都需要把当前travel加入到pq中并计算capacity，一旦发现超载直接return false
 */
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0 || capacity == 0) return false;
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < trips.length; i++) {
            while (!pq.isEmpty() && pq.peek()[2] <= trips[i][1]) {
                capacity += pq.poll()[0];
            }

            capacity -= trips[i][0];
            pq.offer(trips[i]);
            if (capacity < 0) return false;
        }
        return true;
    }
}
