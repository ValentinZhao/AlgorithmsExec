package lc694;

import java.util.HashSet;
import java.util.Set;

/**
 * 算法创新点在于使用xPos和yPos来绘制岛的形状，只要岛形状一致就会生成一串相同的xPosyPos坐标
 */
public class Solution694 {
    private static int[][] dirs= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Set<String> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    dfs(grid, i, j, 0, 0, builder);
                    String island = builder.toString();
                    if(!set.contains(island)){
                        result++;
                        set.add(island);
                    }
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j, int xPos, int yPos, StringBuilder builder) {
        grid[i][j] = 0;
        builder.append(xPos+""+yPos);
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) continue;
            dfs(grid, x, y, xPos + dir[0], yPos + dir[1], builder); // xpos ypos也增加
        }
    }
}
