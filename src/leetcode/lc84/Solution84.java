package lc84;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // 为什么遍历n+1次呢？因为最后一次我们把h给到0，这样就能在最后再次计算一次以最后一个bar为高度的
            // 最大矩形面积，这样防止类似[1,1,2,1]这样的test case，就是在最大的高度后面又有一系列更低的可以组最大面积
            int h = i == n ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int currentHeight = heights[stack.pop()];
                int lastIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = currentHeight * (i - lastIndex - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
