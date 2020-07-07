package bytedance.leetcode;

import TreeNode.TreeNode;

public class Solution124 {
    private int maxValue;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxValue = Integer.MIN_VALUE;
        helper(root);
        return maxValue;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxValue = Math.max(maxValue, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
