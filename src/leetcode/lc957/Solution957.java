package lc957;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) return cells;
        Set<String> set = new HashSet<>();
        int cycle = 0;
        boolean hasCycle = false; // hasCycle的意思是我们不断遍历cell的情况，直到遍历到跟初始情况一样的状态，就称为状态出现了环
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if (!set.contains(key)) {
                set.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if (hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int n = cells.length;
        int[] next = new int[n];
        for (int i = 1; i < n - 1; i++) {
            next[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return next;
    }
}
