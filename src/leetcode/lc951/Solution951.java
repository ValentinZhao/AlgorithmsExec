package lc951;

import TreeNode.TreeNode;

/**
 * If root1 or root2 is null, then they are equivalent if and only if they are both null.
 *
 * Else, if root1 and root2 have different values, they aren't equivalent.
 *
 * Else, let's check whether the children of root1 are equivalent to the children of root2. There are two different ways to pair these children.
 */
public class Solution951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        // 到这里就是说，root1和root2有相同的节点值，但是子树并不相同，所以root1 != root2但是root1.val == root2.val
        // 可以进入下面的逻辑
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
    }
}
