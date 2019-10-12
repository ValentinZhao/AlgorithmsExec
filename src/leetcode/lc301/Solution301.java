package lc301;

import java.util.*;

/**
 * 利用BFS进行层级遍历，每一层，指代的是去掉一个左括号或右括号，并且valid的一个字符串的集合
 * 下一层就是再少一个左右括号的valid的字符串集合，以此类推，太巧妙了！
 */
public class  Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null) return list;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                list.add(cur);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                String temp = cur.substring(0, i) + cur.substring(i+1);
                if (!set.contains(temp)) {
                    queue.offer(temp);
                    set.add(temp);
                }
            }
        }
        return list;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }
}

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean found = false;
        queue.offer(s);
        set.add(s);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (isValid(curr)) {
                found = true;
                res.add(curr);
            }
            if (found) continue;
            for (int i = 0; i < curr.length(); i++) {
                while (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                String temp = curr.substring(0, i) + curr.substring(i+1);
                if (!set.contains(temp)) {
                    queue.offer(temp);
                    set.add(temp);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}