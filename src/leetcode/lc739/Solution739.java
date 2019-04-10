package lc739;

import java.util.Stack;

/**
 * 这题的解法是，stack里面存着数组元素的index，然后再判断当前节点与栈顶元素之间的关系，如果当前元素比栈顶元素大，则不断出栈
 * 找到第一个比栈顶元素小的位置，做一下减法就有了时间差；那么时间差是要在栈内尚有元素的情况下的，否则空栈的话其实表示的是当前元素过大，没有元素能大过它
 * 同时由于是和栈顶元素比较，我们势必要从数组尾部开始遍历
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(N-1);
        for (int i = N-2; i >= 0 ; i--) {
            // 注意下面的条件是大于等于都是不行的
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            if (!stack.isEmpty()) ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
