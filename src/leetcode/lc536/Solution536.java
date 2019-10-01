package lc536;

import TreeNode.TreeNode;

import java.util.Stack;

public class Solution536 {
    public TreeNode str2tree(String s) {
        int n = s.length();
        Stack<TreeNode> stack = new Stack<>();
        // 因为i会在下面的逻辑中推进，j作为记录i原本位置的指针，用来计算一个substring的数值
        for (int i = 0, j = i; i < n; i++, j = i) {
            char c = s.charAt(i);
            if (c == ')') stack.pop();
            else if (c >= '0' && c <= '9' || c == '-') {
                // 我们直接用i+1去判断是否是数字，所以最后i会落在'('前面的最后一个数字上
                while (i + 1 < n && s.charAt(i+1) >= 0 && s.charAt(i+1) <= 9) i++;
                int num = Integer.valueOf(s.substring(j, i+1));
                TreeNode node = new TreeNode(num);
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) parent.right = node;
                    else parent.left = node;
                }
                // 这里最后一定会把最底层节点推入stack中，就算他是叶子节点，比如只有(2)这样
                // 他也会在下层循环中因为下一位为')'而推出，太巧妙了！
                stack.push(node);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}
