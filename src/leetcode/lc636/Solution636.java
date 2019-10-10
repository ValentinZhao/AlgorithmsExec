package lc636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 这题很简单，因为所有Task都是single thread的
 * 意味着，如果我们把所有任务都扔进栈，那么遇到任务结束的log时
 * 栈顶元素一定是他自己，因为其他任务都在等他结束，不可能先于他结束
 * 就这样一直遍历完log即可
 */
public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Deque<int[]> stack = new ArrayDeque<>();

        for (String task : logs) {
            String[] info = task.split(":");
            int idx = Integer.valueOf(info[0]), start = Integer.valueOf(info[2]);
            if (info[1].equals("start")) {
                stack.push(new int[]{idx, start});
            } else {
                int span = start - stack.pop()[1] + 1;
                res[idx] += span;
                if (!stack.isEmpty()) res[stack.peek()[0]] -= span;
            }
        }
        return res;
    }
}
