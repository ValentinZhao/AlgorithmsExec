package lc542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一开始想用DFS解决，但是发现方向问题没法解决，看了下答案也确实没人用DFS。。
 * 标准解答是BFS，思路其实差不多，首先把非0元素设置成MAX方便更新，然后也是想四周**前进一步**，而不是DFS到底，DFS的问题就是会遇到过去又回来不断死循环的问题
 * 到下个位置与刚才的位置比较，如果下个位置元素大过2的话，说明刚才有元素到过这里，有一个到0的路线访问过，要把下个位置更新成稍微小一些的数毕竟现在这个路线更加nearest
 * 但是如果只相差1就没必要更新因为其实和上条到这里路径的加权是一样的
 */
public class Solution542 {
    public static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int row = matrix.length, col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) queue.offer(new int[]{i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= col ||
                    matrix[x][y] <= matrix[cell[0]][cell[1]] + 1) continue;
                // 找到这个递增点了，塞入队列下一轮可以从他开始
                queue.offer(new int[]{x, y});
                matrix[x][y] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }

}
