package lc773;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * For everyone who still does not understand why we should use this as direction pad: PUT 2X3 BOARD AS MATRIX instead of string ,even though we use indices in string as position. For instance, for 2x3 board [[1,0,2], [5,4,6]] it should be like
 *
 * 1 0 2
 * 5 4 6
 *
 * and as I quote,
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * Now you see where little ZERO could move? Yep, for 4-directions it could only swaps with 1, 2 or 4, indicating their indices is {0, 2, 4} in the string "102546", and so on.
 */
public class Solution773 {
    public static int[][] dirs = new int[][]{{1, 4}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) return step;

                int zero = cur.indexOf('0');
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (set.contains(next)) continue;
                    queue.offer(next);
                    set.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        StringBuilder builder = new StringBuilder(s);
        builder.setCharAt(i, s.charAt(j));
        builder.setCharAt(j, s.charAt(i));
        return builder.toString();
    }
}
