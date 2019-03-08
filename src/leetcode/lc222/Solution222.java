package lc222;

import TreeNode.TreeNode;

/**
 * 首先是一个complete binary tree的概念，它是指一颗二叉树如果满足除了最后一行外所有节点都不为空，并且最后一行本身的节点都尽量靠左的一种二叉树
 * 那么本题要求读出给定的完全二叉树的节点数。我们利用大神Stefan的二分查找方法，先通过读左子树来读root的高度（毕竟所有子节点都尽量靠左）先确认2个事实：
 * 1. 我们在读root.right的时候，如果这个高度正好是root的height-1的话，这证明最后一行上root的左右子树都有节点，毕竟height-1的意思就是整体高度减去根节点本身
 * 所以我们只需要计算2^h（左子树所有）+root.right的递归返回即可
 * 2. root.right的height小于height-1的时候，这说明root右子树并没有填到最后一层，有可能左子树也没填满左边的最后一层，但是，右子树的h-1层肯定是满了，所以才会
 * 剩几个填到下一层的左子树最后一层中，这样的话就是2^(h-1) (右子树所有) + root.left的递归
 */
public class Solution222 {
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 : height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) :
                                                         (1 << h - 1) + countNodes(root.left);
    }
}
