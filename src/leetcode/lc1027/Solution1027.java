package lc1027;

import java.util.HashMap;
import java.util.Map;

/**
 * 这题就是数这一串里面出现的最长的等差数列有多长
 * 其实方法就是brute force，两两比较
 * 用map存对应diff出现的次数
 *
 * dp[diff][index] equals to the length of arithmetic sequence at index with difference diff.
 */
public class Solution1027 {
    public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        // diff -> 这个差的出现次数
        Map<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                map[j].put(diff, map[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, map[j].get(diff));
            }
        }
        return res;
    }
}
