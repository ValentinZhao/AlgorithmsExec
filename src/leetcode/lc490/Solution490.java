package lc490;

/**
 * 迷宫系列题，也是非常经典的DFS解法题，下面这种解法非常优雅
 */
public class Solution490 {
    private static int[][] dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        // visited记录的是所有作为起点过的点
        boolean[][] visited = new boolean[m][n];
        return moveBallDFS(maze, start, destination, visited);
    }

    private boolean moveBallDFS(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) return false;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        visited[start[0]][start[1]] = true;
        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            if (dir[0] == 0) {
                while (y+dir[1] >= 0 && y+dir[1] < maze[0].length && maze[x][y+dir[1]] != 1) y += dir[1];
            } else {
                while (x+dir[0] >= 0 && x+dir[0] < maze.length && maze[x+dir[0]][y] != 1) x += dir[0];
            }
            if (moveBallDFS(maze, new int[]{x, y}, destination, visited)) return true;
        }
        return false;
    }
}