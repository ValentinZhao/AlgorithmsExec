package bytedance.leetcode;

import TreeNode.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        return doInvert(root);
    }

    private TreeNode doInvert(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = doInvert(root.right);
        newRoot.right = doInvert(root.left);

        return newRoot;
    }
}
