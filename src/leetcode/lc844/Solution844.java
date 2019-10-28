package lc844;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chs = S.toCharArray();
        for (char c : chs) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
                break;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        S = sb.toString();
        stack.clear();
        chs = T.toCharArray();
        for (char c : chs) {
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
                break;
            }
            stack.push(c);
        }
        sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        T = sb.toString();
        return S.equals(T);
    }
}
