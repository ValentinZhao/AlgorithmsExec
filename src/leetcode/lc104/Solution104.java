package lc104;

import TreeNode.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return -1;
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);
    }
}
