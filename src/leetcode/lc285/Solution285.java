package lc285;

import TreeNode.TreeNode;

import java.util.Stack;

public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        // perform in-order traversal
        Stack<TreeNode> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (p.val == max) return root;
                max = root.val;
                root = root.right;
            }
        }
        return null;
    }
}
