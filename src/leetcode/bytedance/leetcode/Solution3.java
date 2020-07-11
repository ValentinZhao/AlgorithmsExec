package bytedance.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            // 这里保证了，重复的字符，和它之前的部分都会被推出队列，留下的部分一定不会和当前字符重复
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c); // 把这个字符补在后面
            res = Math.max(res, queue.size());
        }
        return res;
    }
}
