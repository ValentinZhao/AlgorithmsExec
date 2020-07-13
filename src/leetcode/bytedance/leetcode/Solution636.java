package bytedance.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Deque<int[]> stack = new ArrayDeque<>();

        for (String task : logs) {
            String[] info = task.split(":");
            int idx = Integer.parseInt(info[0]), start = Integer.parseInt(info[2]);
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
