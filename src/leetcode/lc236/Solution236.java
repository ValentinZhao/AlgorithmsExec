package lc236;

import TreeNode.TreeNode;

/**
 * 整个查找的流程是，先通过递归不断向下找子树中的p和q，也就是两个目标节点。一旦找到，就向上层来返回这个
 * p或q的root，也就是left和right这两个左右子树的递归结果，然后再根据这两棵子树的返回情况返回LCA(Lowest Common Ancestor)即可
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if (left == null && right == null) return null; // 根本没找到p或q在子树里
        if (left != null && right != null) return root; // 左子树有p或q，右子树也有p或q，也就是说在这个root两边分别有p和q，那LCA就是这个root
        return left == null ? right : left; // 这样的情况是p和q都在子树的左边或右边，这样就返回不为null的那棵子树即可
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}