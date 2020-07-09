package bytedance.leetcode;

import TreeNode.TreeNode;

public class Solution129 {
    int maxValue = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return maxValue;
    }

    private void helper(TreeNode root, int curr) {
        if (root == null) return;
        int tmp = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            maxValue += tmp;
            return;
        }
        if (root.left != null) helper(root.left, tmp);
        if (root.right != null) helper(root.right, tmp);
    }
}
