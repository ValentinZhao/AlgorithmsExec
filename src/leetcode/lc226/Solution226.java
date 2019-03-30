package lc226;

import TreeNode.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    private TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = invert(root.right);
        newRoot.right = invert(root.left);
        return newRoot;
    }
}
