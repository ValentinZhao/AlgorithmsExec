package bytedance.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution155 {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> mins = new ArrayDeque<>();

    public void push(int node) {
        stack.push(node);
        if (mins.isEmpty()) mins.push(node);
        else {
            if (node <= mins.peek()) mins.push(node);
        }
    }

    public void pop() {
        int tmp = stack.pop();
        if (tmp == mins.peek()) mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return mins.peek();
    }
}
