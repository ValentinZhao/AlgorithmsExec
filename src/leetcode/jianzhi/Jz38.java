package jianzhi;

import TreeNode.TreeNode;

public class Jz38 {
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int nLelt=TreeDepth(root.left);
        int nRight=TreeDepth(root.right);

        return nLelt>nRight?(nLelt+1):(nRight+1);
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
