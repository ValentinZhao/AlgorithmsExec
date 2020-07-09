package bytedance.leetcode;

import TreeNode.TreeNode;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                root.left = helper(preorder, preStart+1, preStart+i-inStart, inorder, inStart, i-1);
                root.right = helper(preorder, preStart+i-inStart+1, preEnd, inorder, i+1, inEnd);
            }
        }

        return root;
    }
}
