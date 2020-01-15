package lc1062;

import java.util.HashSet;

public class Solution1062 {
    public int longestRepeatingSubstring(String S) {
        int n = S.length();

        // left从1开始，意味着这个窗口宽度最大就是1了
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (search(mid, n, S) != -1) left = mid + 1;
            else right = mid;
        }

        return left - 1;
    }

    private int search(int L, int n, String S) {
        HashSet<String> seen = new HashSet();
        String tmp;
        for(int start = 0; start < n - L + 1; ++start) {
            tmp = S.substring(start, start + L);
            if (seen.contains(tmp)) return start;
            seen.add(tmp);
        }
        return -1;
    }
}
