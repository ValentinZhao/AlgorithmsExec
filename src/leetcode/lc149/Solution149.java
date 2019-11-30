package lc149;

import java.util.HashMap;
import java.util.Map;

public class Solution149 {
    public int maxPoints(int[][] points) {
        int res = 0;
        int n = points.length;
        if (n == 0) return 0;
        if (n <= 2) return n;
        for (int i = 0; i < n-1; i++) {
            Map<String, Integer> map = new HashMap<>(); // 每次开始遍历新的点，都重置map
            int lineMax = 0; // 当前点可以达到的最多共线点的数量
            int overlap = 0;
            for (int j = i+1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcp = getGcp(x, y);
                x /= gcp;
                y /= gcp;
                String slope = String.valueOf(x) + String.valueOf(y);
                int count = map.getOrDefault(slope, 0);
                count++;
                map.put(slope, count);
                lineMax = Math.max(lineMax, count);
            }

            res = Math.max(res, lineMax + overlap + 1); // 别忘了加上自己，所以加1
        }

        return res;
    }

    private int getGcp(int x, int y) {
        if (y == 0) return x;
        return getGcp(y, x % y);
    }


}
