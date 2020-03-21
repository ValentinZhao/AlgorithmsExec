package lc226;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    // recursive
    private TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = invert(root.right);
        newRoot.right = invert(root.left);
        return newRoot;
    }

    // iterative
    public void invertByStack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            swap(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }


    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
