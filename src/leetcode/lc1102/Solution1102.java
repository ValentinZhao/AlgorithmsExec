package lc1102;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution1102 {
    public int maximumMinimumPath(int[][] A) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        heap.offer(new int[]{A[0][0], 0, 0});
        int maxScore = Integer.MAX_VALUE, n = A.length, m = A[0].length;;
        A[0][0] = -1;

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int r = cur[1], c = cur[2], score = cur[0];
            maxScore = Math.min(maxScore, score);
            if (r == n-1 && c == m-1) return maxScore;
            for (int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] > 0) {
                    heap.offer(new int[]{A[x][y], x, y});
                    A[x][y] = -1;
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        return -1;
    }
}
