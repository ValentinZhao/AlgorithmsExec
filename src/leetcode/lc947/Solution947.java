package lc947;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 注意这题给的坐标是任意二维数组的所有stone的坐标
 * 那么我们只需要暴力dfs找所有同行同列的stone组成的岛屿数，再用整个stone数减去它就是要remove掉的stone数
 */
public class Solution947 {
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int islandsCount = 0;
        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                detectIslandDFS(stone, visited, stones);
                islandsCount++;
            }
        }
        return stones.length - islandsCount;
    }

    private void detectIslandDFS(int[] stone, Set<int[]> visited, int[][] stones) {
        visited.add(stone);
        for (int[] nextStone : stones) {
            if (!visited.contains(nextStone)) {
                if (nextStone[0] == stone[0] || nextStone[1] == stone[1]) {
                    detectIslandDFS(nextStone, visited, stones);
                }
            }
        }
    }

    // Here is another way based on Union Find

    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones2(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }
}
