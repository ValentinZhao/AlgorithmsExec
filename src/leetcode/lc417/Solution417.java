package lc417;

import java.util.LinkedList;
import java.util.List;

public class Solution417 {
    public static int[][] dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        // 从上左边，也就是所谓的Pacific Ocean的每个点出发dfs看能否到达
        // 从右下边，也就是Atlantic Ocean的每个点出发做dfs看能否到达
        // 在dfs中要设置visited，否则在进行返回方向的dfs时可能会有死循环（本题虽然不适用，因为有高度降序的限制）
        // 死循环比如跳回上个点，在上个点dfs回当前点这样，本题的visited还充当洋流路径，当pacific[x][y]和atlantic[x][y]都是true时
        // 证明从此点出发的至少两条洋流可以到两片大洋
        for (int i = 0; i < row; i++) {
            currentFlowDFS(matrix, pacific, Integer.MIN_VALUE, i, 0);
            currentFlowDFS(matrix, atlantic, Integer.MIN_VALUE, i, col-1);
        }
        for (int i = 0; i < col; i++) {
            currentFlowDFS(matrix, pacific, Integer.MIN_VALUE, 0, i);
            currentFlowDFS(matrix, atlantic, Integer.MIN_VALUE, row-1, i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(new int[]{i ,j});
            }
        }
        return res;
    }

    private void currentFlowDFS(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        if (x < 0 || x >= matrix.length ||
                y < 0 || y >= matrix[0].length ||
                visited[x][y] || height > matrix[x][y]) return;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            currentFlowDFS(matrix, visited, matrix[x][y], x+dir[0], y+dir[1]);
        }
    }
}
