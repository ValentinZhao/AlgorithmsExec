package lc286;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用层级遍历，我们先推入所有的0（gate），然后按层遍历，这里的"层"其实是指所有满足条件的一组坐标
 * 然后我们在他们的周围找INF，推入队列准备继续这样向外扩张，相当于每个层级遍历就是在一系列点周围四向散开遍历
 */
public class Solution286 {
    public static int[][] dirs = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                for (int[] dir : dirs) {
                    int row = top[0] + dir[0];
                    int col = top[1] + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n) continue;
                    if (rooms[row][col] == Integer.MAX_VALUE) {
                        rooms[row][col] = rooms[top[0]][top[1]] + 1;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }
    }
}
