package lc317;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 其实就是基本的BFS寻最短路径，然后我们只需要多维护一个reach数组和dist数组来记录走到的位置和遍历过的距离即可
 *
 * 标记，经典BFS寻最短路径带一点followup
 */
public class Solution317 {
    private static int[][] dirs = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
    private int rows;
    private int cols;
    public int shortestDistance(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int buildings = 0;
        int[][] dist = new int[rows][cols];
        int[][] reach = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    findShortestPathBFS(grid, dist, reach, i, j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private void findShortestPathBFS(int[][] grid, int[][] dist, int[][] reach, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        boolean[][] visited = new boolean[rows][cols];
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] prevDir = queue.poll();
                for (int[] dir : dirs) {
                    int curX = prevDir[0] + dir[0];
                    int curY = prevDir[1] + dir[1];
                    if (curX >= 0 && curX < rows && curY >= 0 && curY < cols &&
                        grid[curX][curY] == 0 && !visited[curX][curY]) {
                        reach[curX][curY]++;
                        visited[curX][curY] = true;
                        queue.offer(new int[]{curX, curY});
                        dist[curX][curY] += step;
                    }
                }
            }
            step++;
        }
    }
}
