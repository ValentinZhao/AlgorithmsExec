package lc1145;

import TreeNode.TreeNode;

/**
 * 这题其实就是，我们要赢可以选的点只有三处。x的左右子节点或者它的父节点。
 * 子节点是指，比如x的左子树有10个节点，右子树有5个。这时候我们直接选定左子树root，player1就不能再往左子树走了
 * 当然你可以说player1可以走父节点向上，这也是对的。所以我们是在父节点、左右子树root间选择最大值，并且该值大于n/2。即可搞定这题
 */
public class Solution1145 {
    private int left, right, val;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        countNodesDFS(root);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private int countNodesDFS(TreeNode root) {
        if (root == null) return 0;
        int l = countNodesDFS(root.left);
        int r = countNodesDFS(root.right);

        if (root.val == val) {
            left = l;
            right = r;
        }

        return l + r + 1;
    }
}
