package lc1088;

import java.util.HashMap;
import java.util.Map;

public class Solution1088 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] nums = new int[]{0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int[] count = new int[1];

        dfs(0, N, count);

        return count[0];
    }

    private void dfs(int start, int N, int[] count) {
        if (start > N) return;

        if (isConfused(start)) count[0]++;

        int idx = start == 0 ? 1 : 0;
        for (;idx < 5; idx++) {
            // 我们只需要在个位塞01689遍历即可，塞其他数字根本不会成立，避免重复计算
            dfs(start*10+nums[idx], N, count);
        }
    }

    private boolean isConfused(int start) {
        long x = start, res = 0;

        while (x > 0) {
            int d = (int) (x % 10);
            if (!map.containsKey(d)) return false;
            res = res * 10 + map.get(d);
            x /= 10;
        }

        return res != start;
    }


}
