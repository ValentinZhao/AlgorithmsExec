package jianzhi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Jz64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || size <= 0) return null;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>(); // 存数组索引

        for (int i = 0; i < num.length; i++) {
            // 队列头已经滑出窗口外，则推出
            while (!queue.isEmpty() && queue.peek() < i - size + 1) {
                queue.poll();
            }

            // 队列尾比即将入队的小，推出直到队列尾比当前元素大
            while (!queue.isEmpty() && queue.peekLast() < num[i]) {
                queue.pollLast();
            }

            queue.offer(num[i]);

            if (i >= size - 1) { // 迭代到完整的窗口大小才能开始积累答案
                list.add(num[queue.peek()]);
            }
        }

        return list;
    }
}
