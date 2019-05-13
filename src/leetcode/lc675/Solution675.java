package lc675;

import java.util.*;

/**
 * 首先我们需要把树按照树的高度的顺序进行砍伐，那么我们确实需要一个pq来存这些数据，new int[]{row, col, height}，sorted by int[2]
 * 然后推出树节点，然后用BFS来找最短路径，就像Dijskstra一样，不知道为什么最短路径用BFS就看一下Dj
 */
public class Solution675 {
    private static int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int rows = forest.size();
        int cols = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int treeHeight = forest.get(i).get(j);
                if (treeHeight > 1) pq.offer(new int[]{i, j, treeHeight});
            }
        }
        int sum = 0;
        int[] start = new int[2];
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree, rows, cols);
            if (step < 0) return -1;
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }

    private int minStep(List<List<Integer>> forest, int[] start, int[] tree, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int step = 0;
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                /**
                 * 设定退出loop条件，找到tree的位置就退出
                 */
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;
                for (int[] dir : dirs) {
                    int curRow = curr[0] + dir[0];
                    int curCol = curr[1] + dir[1];
                    if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols ||
                        visited[curRow][curCol] || forest.get(curRow).get(curCol) == 0) continue; // 0代表墙，过不去
                    queue.offer(new int[]{curRow, curCol});
                    visited[curRow][curCol] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
