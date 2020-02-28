package bytedance;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwoStacksQueue {

    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();

    public void push (int node) {
        stack1.push(node);
    }

    public int pop() throws InvalidArgumentException {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }

        if (stack2.isEmpty()) throw new InvalidArgumentException(new String[]{"Queue is empty!"});

        return stack2.pop();
    }
}
