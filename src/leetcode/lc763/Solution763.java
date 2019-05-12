package lc763;

import java.util.ArrayList;
import java.util.List;

/**
 * 首先记录下所有字符最后一次出现的位置，然后设定两个指针start和end，如果当前遍历字符出现在end后面我们就把end延长到那个位置，
 * 如果说某个数的最后出现位置和end正好重合，我们就知道完成了一个partition
 */
public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i)-'a']);
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
