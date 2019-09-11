package lc397;

import java.util.HashMap;
import java.util.Map;

public class Solution397 {
    private static Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement (int num) {
        if (num < 1) return 0;

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= num; i++) {
            int step = findSteps(num);
            map.put(i, step);
            res = Math.min(res, step);
        }
        return res;
    }

    private int findSteps(int num) {
        if (num <= 1) return 0;
        if (map.containsKey(num)) return map.get(num);
        if (num % 2 == 0) return 1 + findSteps(num / 2);
        else return 1 + Math.min(findSteps(num+1), findSteps(num-1));
    }
}
