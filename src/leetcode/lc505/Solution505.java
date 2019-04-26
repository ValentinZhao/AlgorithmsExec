package lc505;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution505 {
    // DFS逻辑没啥问题，但是TLE了
    private static int[][] dirs= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private int minLen = Integer.MAX_VALUE;
    public int shortestDistance1(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return readPathDFS(maze, start, destination, visited, 0);
    }

    private int readPathDFS(int[][] maze, int[] start, int[] destination, boolean[][] visited, int distance) {
        if (visited[start[0]][start[1]]) return -1;
        if (start[0] == destination[0] && start[1] == destination[1]) return distance;
        visited[start[0]][start[1]] = true;
        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            int len = 0;
            if (dir[1] == 0) {
                while (x+dir[0] >= 0 || x+dir[0] < maze.length || maze[x+dir[0]][y] != 1) {
                    x += dir[0];len++;
                }
            } else {
                while (y+dir[1] >= 0 || y+dir[1] < maze[0].length || maze[x][y+dir[1]] != 1) {
                    y += dir[1];len++;
                }
            }
            int dist = readPathDFS(maze, new int[]{x, y}, destination, visited, distance + len);
            if (dist != -1) return Math.min(minLen, dist);
        }
        return -1;
    }

    // BFS的方法
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] length = new int[m][n];
        PriorityQueue<MazePoint> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.l));
        pq.offer(new MazePoint(start[0], start[1], 0));
        for (int i = 0; i < m * n; i++) length[i/n][i%n] = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            MazePoint p = pq.poll();
            if (length[p.x][p.y] <= p.l) continue; // 已经有过一个更小的值的话，就相当于visited过了，直接跳过
            length[p.x][p.y] = p.l;
            for (int[] dir : dirs) {
                int x = p.x;
                int y = p.y;
                int len = p.l;
                if (dir[1] == 0) {
                    while (x+dir[0] >= 0 || x+dir[0] < maze.length || maze[x+dir[0]][y] != 1) {
                        x += dir[0];len++;
                    }
                } else {
                    while (y+dir[1] >= 0 || y+dir[1] < maze[0].length || maze[x][y+dir[1]] != 1) {
                        y += dir[1];len++;
                    }
                }
                pq.offer(new MazePoint(x, y, len));
            }
        }
        return length[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : length[destination[0]][destination[1]];
    }

    class MazePoint {
        int x, y, l;
        public MazePoint(int _x, int _y, int _l) {
            x = _x;
            y = _y;
            l = _l;
        }
    }
}
