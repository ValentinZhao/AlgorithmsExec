package lc489;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * 基本算法就是backtracking+DFS的方法，下面有丰富的图解
 *
 * https://leetcode.com/problems/robot-room-cleaner/solution/
 *
 * 主要就是注意方向一定要按照up - right - down - left的方向来走，因为我们是按照right-hand rule来走迷宫的
 */
public class Solution489 {
    public int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}}; // 方向一定要这样
    public void cleanRoom(Robot robot) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        backtracking(robot, visited, 0, 0, 0);
    }

    /**
     *
     * @param robot
     * @param visited
     * @param row
     * @param col
     * @param direction 0 -> up 1 -> left 2 -> down 3 -> right
     */
    private void backtracking(Robot robot, Set<Pair<Integer, Integer>> visited, int row, int col, int direction) {
        visited.add(new Pair<>(row, col));
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newDir = (direction + i) % 4;
            int newRow = row + dirs[newDir][0];
            int newCol = col + dirs[newDir][1];
            if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) {
                backtracking(robot, visited, newRow, newCol, newDir);
                // backtracking都是这样的，把这个递归走完之后恢复状态，就是所谓的"回溯"
                goBack(robot);
            }
            robot.turnRight(); // 记得把机器人转向啊！！！
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    class Robot {
        Robot() { }

        public boolean move() {
            return true;
        }

        public void turnLeft() { }

        public void turnRight() {}

        public void clean() { }
    }
}

/**
 * 几个重要的点，一开始机器人一定是面朝上的，然后机器人只有原地左转或右转，然后前进这样的指令
 * 所以我们为了可以方便的进行DFS，我们一定要设定好一个**顺时针的方向顺序**，这样只要在递归中不断调用turnRight()即可
 * 就可以调出下层递归后，记得回到原来的位置，换个方向继续DFS
 *
 * 这道题不一样的就是，机器人转向要额外调用API，而不能自由地进行四方向遍历，所以才写成这样子
 */
class Solution {
    public int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}}; // 方向一定要这样

    public void cleanRoom(Robot robot) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        // 这里面给了一个row col的坐标，其实坐标没关系，我们主要是用来push给set来避免重复访问的
        cleanRoomDFS(robot, visited, 0, 0);
    }

    private void cleanRoomDFS(Robot robot, Set<Pair<Integer, Integer>> visited, int row, int col) {
        if (visited.contains(new Pair<>(row, col))) return;
        visited.add(new Pair<>(row, col));
        robot.clean();
        for (int[] dir : dirs) {
            int newX = dir[0] + row;
            int newY = dir[1] + col;
            if (robot.move()) {
                cleanRoomDFS(robot, visited, newX, newY);
                // 我们调用了robot.move()来确定前面能不能走
                // 但是，如果是能走的，那么机器人就已经移动了！！
                // 所以我们结束这个方向的DFS后要回到原来的位置上去
                goBack(robot);
            }
            // 一个方向结束，循环到下个方向，机器人也手动转向
            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    class Robot {
        Robot() { }

        public boolean move() {
            return true;
        }

        public void turnLeft() { }

        public void turnRight() {}

        public void clean() { }
    }
}
