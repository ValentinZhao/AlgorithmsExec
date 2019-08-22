package lc316;

import java.util.*;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        if (s == "") return s;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        int i = 0;
        int pos = -1;
        boolean[] used = new boolean[26];
        int[] cache = null;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            if (used[s.charAt(i) - 'a']) {
                i++;
                continue;
            }
            if (pos == -1 || s.charAt(i) < s.charAt(pos)) {
                pos = i;
                cache = cnt.clone();
            }
            if (--cnt[s.charAt(i) - 'a'] == 0) {
                i = pos;
                cnt = cache;
                used[s.charAt(i) - 'a'] = true;
                pos = -1;
                builder.append(s.charAt(i));
            }
            i++;
        }
        return builder.toString();
    }
}

/**
 * Greedy做法，为了保证不重复并且保持最小字典序，我们利用栈，每次推入字符时都检查是否当前栈要推出，推出的条件有两个，需要同时满足
 * 1. 栈顶元素大于当前遍历元素
 * 2. 被遍历元素在后面的字符串中还存在，可以后面再塞入
 *
 * 这样就可以保证最小的字典序了。关于空间复杂度，我们要维护memo来记录访问过的情况，同时还要记录每个字符最后出现的位置，看起来是O(N)，实则不然
 * 因为字符个数最大是26，所以一直都是常数空间。
 *
 * 那么这题可以被称之为贪心，就是因为每一步我们都仔细的去比较是否是最小字典序，并且保证了只出现一次的要求，每一步都是取最好的结果，自然是贪心的思想
 * 具体参照 https://leetcode.com/problems/remove-duplicate-letters/solution/
 */

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() &&
                    lastIndex.get(stack.peek()) > i) seen.remove(stack.pop());
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : stack) builder.append(c.charValue());
        return builder.toString();
    }
}


