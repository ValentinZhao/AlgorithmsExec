package lc885;

import java.util.ArrayList;
import java.util.List;

public class Solution885 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};// east, south, west, north的顺序
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{r0, c0});
        // currentDir是当前方向，len是当前方向需要走几步
        int currentDir = 0, len = 0;

        while (res.size() < R * C) {
            // 向东向西时，len要增加一步
            if (currentDir == 0 || currentDir == 2) len++;
            for (int i = 0; i < len; i++) {
                // 这里就是本题精妙之处了
                // 无论我们在下面的判断中是否存在与matrix中
                // 我们都按规律把坐标持续增加，只add那些在matrix坐标系内的
                r0 += dirs[currentDir][0];
                c0 += dirs[currentDir][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) res.add(new int[]{r0, c0});
            }
            currentDir = (currentDir + 1) % 4;
        }
        return res.toArray(new int[R*C][2]);
    }
}