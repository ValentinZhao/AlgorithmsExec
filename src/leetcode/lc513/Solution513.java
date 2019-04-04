package lc513;

import TreeNode.TreeNode;

public class Solution513 {
    int[] leftMostValue = new int[]{0, 0};
    public int findBottomLeftValue(TreeNode root) {
        readLeftMostNode(root, 1);
        return leftMostValue[0];
    }

    private void readLeftMostNode(TreeNode root, int level) {
        if (root == null) return;
        if (level > leftMostValue[1]) {
            leftMostValue = new int[]{root.val, level};
        }
        readLeftMostNode(root.left, level+1);
        readLeftMostNode(root.right, level+1);
    }
}
