package lc129;

import TreeNode.TreeNode;

public class Solution129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        int current = 0;
        addUpAllPaths(root, current);
        return sum;
    }

    private void addUpAllPaths(TreeNode root, int currnet) {
        if (root == null) return;
        currnet = 10 * currnet + root.val;
        if (root.left == null && root.right == null) {
            sum += currnet;
            return;
        }
        addUpAllPaths(root.left, currnet);
        addUpAllPaths(root.right, currnet);
    }
}
