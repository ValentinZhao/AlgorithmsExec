package alibaba;

import java.util.*;

public class Exec {
    public static int maxValue = 0;
    public static void main(String[] args) {
        triangle();
    }

    public void nth (int n) {
//        Scanner input=new Scanner(System.in);
//        int nn = input.nextInt();

    }

    public static void triangle() {
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        int m = 2*n-1;
        Node[][] map = new Node[n][m];
        for (int i = 0; i < n; i++) {
            int init = m/2-(i+1)+1;
            for (int j = 0; j < 2 * (i+1) - 1; j++) {
                map[i][init] = new Node(i, init++, input.nextInt());
            }
        }

       dfs(map, 0, m/2, map[0][m/2].val);
        System.out.println(maxValue);
    }

    private static void dfs(Node[][] map, int x, int y, int curr) {
        if (x+1 == map.length) {
            maxValue = Math.max(curr, maxValue);
            return;
        }

        dfs(map, x+1, y-1, curr+map[x+1][y-1].val);
        dfs(map, x+1, y, curr+map[x+1][y].val);
        dfs(map, x+1, y+1, curr+map[x+1][y+1].val);
    }

    static class Node {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

}
