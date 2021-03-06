package lc317;

import java.util.ArrayDeque;
import java.util.LinkedList;
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
                    // 你可能会奇怪visited访问过了reach的每一项最多不是1么，但其实是上层有一个循环，从每一个房间开始向外找
                    // 最短的路径，每次重新进入这个方法visited会重置，但reach不会
                    // 而且由于确实每次BFS每个reach至多被遍历到一次，而且每次进入BFS是遍历到房间才进入
                    // 那么就会导致说reach元素值和房间数相等的位置就是房间的位置，我们就可以用这个坐标对应的dist来计算总的路程
                    if (curX >= 0 && curX < rows && curY >= 0 && curY < cols &&
                        grid[curX][curY] == 0 && !visited[curX][curY]) {
                        reach[curX][curY]++;
                        visited[curX][curY] = true;
                        queue.offer(new int[]{curX, curY});
                        // dist是采用每一步都累加的方式，是因为
                        // dist[i][j]就直接表示了从这一点navigate到所有房子的距离和，所以是这样的计算方式（不证明了，知道是啥就行）
                        // 其实也很简单，我们从房子出发，比如房子有三个，在三个方位向这个点出发的时候都有自己的dist to it
                        // 所以在该点是要叠加的。最后dist[i][j]就是从i，j到所有房子的距离和
                        dist[curX][curY] += step;
                    }
                }
            }
            step++;
        }
    }
}

class Solution {
    private static int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int buildings = 0;
        int[][] dist = new int[row][col];
        int[][] reach = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    findBuildingBFS(grid, i, j, reach, dist);
                }
            }
        }
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private void findBuildingBFS(int[][] grid, int row, int col, int[][] reach, int[][] dist) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{row, col});
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int curX = curr[0] + dir[0];
                    int curY = curr[1] + dir[1];
                    if (curX >= 0 && curX < grid.length && curY >= 0 && curY < grid[0].length &&
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