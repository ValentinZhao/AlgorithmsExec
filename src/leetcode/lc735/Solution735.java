package lc735;

import java.util.LinkedList;

/**
 * 只有一种情况会触发碰撞，就是待检测元素为负，栈顶元素为正，其余情况全部塞入栈
 * 那么这些情况包括带检测元素i本身是正数，或者说栈顶元素是负数，这样都是直接压栈
 * 还有种特殊情况是i和栈顶元素是一样大的相反数，那么直接推出栈即可
 */
public class Solution735 {
    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i : a) {
            while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                s.pollLast();
            if (s.isEmpty() || i > 0 || s.getLast() < 0)
                s.add(i);
            else if (i < 0 && s.getLast() == -i)
                s.pollLast();
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}
