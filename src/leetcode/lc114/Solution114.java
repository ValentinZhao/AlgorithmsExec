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
public class  Solution114 {
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

/**
 * 这道题要求把二叉树展开成链表，根据展开后形成的链表的顺序分析出是使用先序遍历，
 * 那么只要是数的遍历就有递归和非递归的两种方法来求解，这里我们也用两种方法来求解。
 * 首先来看递归版本的，思路是先利用 DFS 的思路找到最左子节点，然后回到其父节点，把其父节点和右子节点断开，
 * 将原左子结点连上父节点的右子节点上，然后再把原右子节点连到新右子节点的右子节点上，然后再回到上一父节点做相同操作。
 *
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 *
 *      1
 *     / \
 *    2   5
 *     \   \
 *      3   6
 *       \
 *        4
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }
}