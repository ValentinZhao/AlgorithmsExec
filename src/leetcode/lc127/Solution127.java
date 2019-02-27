package lc127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 利用BFS，通过每一位进行a-z的比较并能够成功匹配wordList中的单词进行入队，最后不断匹配出完全匹配endWord的就是结果了
 * https://leetcode.com/problems/word-ladder/discuss/40717/Another-accepted-Java-solution-(BFS)
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(null); // use null as delimiter of levels
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur != null) {
                for (int i = 0; i < cur.length(); i++) {
                    char[] chs = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String word = new String(chs);
                        if (word.equals(endWord)) return level + 1;
                        if (wordList.contains(word) && !visited.contains(word)) {
                            queue.offer(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;
                if (!queue.isEmpty()) queue.offer(null);
            }
        }
        return 0;
    }
}
