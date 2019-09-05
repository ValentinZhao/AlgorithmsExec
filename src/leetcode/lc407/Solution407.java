package lc407;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 方法就是，从这个平面的边界开始向内BFS，查找它的邻居，如果邻居高度更低，就把这个坐标的高度更新成队头和当前高度较高的那个并入队
 * 我们的队列使用的是最小堆
 */
public class Solution407 {
    public static int[][] dirs = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));
        int res = 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n-1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m-1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) continue;
                visited[row][col] = true;
                res += Math.max(0, cell.height - heightMap[row][col]);
                queue.offer(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
            }
        }
        return res;
    }

    class Cell {
        int row, col, height;
        public Cell (int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}

class Solution {
    private static int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));
        int m = heightMap.length;
        int n = heightMap[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n-1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m-1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] dir : dirs) {
                int row = cur.row + dir[0];
                int col = cur.col + dir[1];
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) continue;
                visited[row][col] = true;
                res += Math.max(0, cur.height - heightMap[row][col]);
                queue.offer(new Cell(row, col, Math.max(cur.height, heightMap[row][col])));
            }
        }
        return res;
    }

    private class Cell {
        int row, col, height;
        public Cell (int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

}