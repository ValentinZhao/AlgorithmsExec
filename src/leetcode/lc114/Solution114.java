package lc114;

import TreeNode.TreeNode;

/**
 * 由于先dfs右边，所以会先把右子树依次取出，按right连接放到prev上，直到栈回退到第一个有左子树的结构，把这段原来的右子树给到左子树的右叶子节点上
 * 毕竟进去的话还是先递归root.right，比如原来是
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 那么会把右子树取出变为
 *     1
 *    /
 *   2
 *  / \
 * 3   4     右子树在prev上，是5->6，同时DFS到节点4，把prev给到root.right就变成了
 *
 *     1
 *    /
 *   2
 *  / \
 * 3   4
 *      \
 *       5
 *        \
 *         6
 *   然后回到节点2，再次递归root.left，把节点3的right安排了，这时候3的right就挂着那一串，接下来退栈，2的right挂着一串，再退栈...
 *
 *   所以总结起来就是非常经典的DFS思想，把右子树的东西给到左子树的最右叶子节点，拼完之后，左子树也会被拼到上面根节点的right，这样形成flatten
 */
public class Solution114 {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
