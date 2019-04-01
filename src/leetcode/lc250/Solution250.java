package lc250;

import TreeNode.TreeNode;

public class Solution250 {
    private static int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        readValidSubtrees(root);
        return count;
    }

    private boolean readValidSubtrees(TreeNode root) {
        if (root == null) return true;
        boolean left = readValidSubtrees(root.left);
        boolean right = readValidSubtrees(root.right);
        if (left && right) {
            if (root.left != null && root.left.val != root.val) return false;
            if (root.right != null && root.right.val != root.val) return false;
            count++;
            /**
             * 返回true的条件有两个，一个是该节点是空，那么它不影响uni-tree的判断，返回true
             * 要不就是该节点不为空且与根节点的值一致
             */
            return true;
        }
        return false;
    }
}
