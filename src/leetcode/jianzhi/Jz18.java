package jianzhi;

import TreeNode.TreeNode;

public class Jz18 {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;

        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;

        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }

    public void Mirror1(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) Mirror1(root.left);
        if (root.right != null) Mirror1(root.right);
    }
}
