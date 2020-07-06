package jianzhi;

public class Jz66 {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return helper(0, 0, threshold, visited, rows, cols);
    }

    private int helper(int x, int y, int threshold, boolean[][] visited, int rows, int cols) {
        if (    x < 0 || x >= rows ||
                y < 0 || y >= cols ||
                digitSum(x) + digitSum(y) > threshold || visited[x][y]) return 0;
        visited[x][y] = true;
        return 1 +  helper(x-1, y, threshold, visited, rows, cols) +
                    helper(x, y-1, threshold, visited, rows, cols) +
                    helper(x+1, y, threshold, visited, rows, cols) +
                    helper(x, y+1, threshold, visited, rows, cols);

    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
}
