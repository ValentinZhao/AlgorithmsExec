package lc235;

import TreeNode.TreeNode;

public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当root比p和q同时大或者同时小的时候，这说明现在该点可能还处于太高或太低的位置
        // 我们需要找到一个点，其value在两个node之间，再由于BST的性质（左<根<右）我们就知道找到LCA了
        while ((root.val - p.val) * (root.val - q.val) > 0)
            // 如果大于一个的话，我们就试图缩小root的值（也就是往左子树走），vice versa
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
