package jianzhi;

import TreeNode.TreeNode;

public class Jz17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        if (isIdentical(root1, root2)) return true;

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        return root1.val == root2.val && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
