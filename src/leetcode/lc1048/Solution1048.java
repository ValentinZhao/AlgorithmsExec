package lc1048;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution1048 {
    // 非常简洁的使用map+dp的做法，
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        int res = 0;

        for (String word :words) {
            if (map.containsKey(word)) continue;
            // map就是每个词对应的最长序列的长度，起始都是单词本身，所以是1
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String next = sb.toString();
                // map.get(next) + 1大于原来的长度我们才用这个更新上去
                if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
                    map.put(word, map.get(next) + 1);
                }
            }
            res = Math.max(res, map.get(word));
        }

        return res;
    }
}
