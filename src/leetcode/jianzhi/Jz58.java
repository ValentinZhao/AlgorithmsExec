package jianzhi;

import TreeNode.TreeNode;

public class Jz58 {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || helper(pRoot.left, pRoot.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;

        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
