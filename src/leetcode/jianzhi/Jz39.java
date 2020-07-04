package jianzhi;

import TreeNode.TreeNode;

public class Jz39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (Math.abs(left - right) >  1) return false;

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
