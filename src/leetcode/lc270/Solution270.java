package lc270;

import TreeNode.TreeNode;

/**
 * 非常好的运用起二分查找的题，BST的最基本的特点，root左边的元素都小于root，右边反之
 * 所以我们不断比较root和target，根据与root.val的大小关系选择进入左子树还是右子树
 */
public class Solution270 {
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(ret - target)) ret = root.val;
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }
}
