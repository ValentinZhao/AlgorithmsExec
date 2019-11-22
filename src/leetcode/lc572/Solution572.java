package lc572;

import TreeNode.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;

        if (isIdentical(s, t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }

}
