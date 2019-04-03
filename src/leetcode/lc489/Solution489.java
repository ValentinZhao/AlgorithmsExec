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
