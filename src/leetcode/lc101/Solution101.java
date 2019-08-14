package lc101;

import TreeNode.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || symmetricHelper(root.left, root.right);
    }

    private boolean symmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return symmetricHelper(left.left, right.right) && symmetricHelper(left.right, right.left);
    }
}