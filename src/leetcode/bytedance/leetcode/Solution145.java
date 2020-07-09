package bytedance.leetcode;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                list.add(0, p.val);
                stack.push(p);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return list;
    }
}
