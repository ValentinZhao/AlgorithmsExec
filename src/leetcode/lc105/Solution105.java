package lc105;

import TreeNode.TreeNode;

/**
 * The basic idea is here:
 * Say we have 2 arrays, PRE and IN.
 * Preorder traversing implies that PRE[0] is the root node.
 * Then we can find this PRE[0] in IN, say it's IN[5].
 * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
 * Recursively doing this on subarrays, we can build a tree out of it :)
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTreeHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        int inIndex = 0; // inIndex是中序遍历的数组中root的位置
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) inIndex = i;
        }
        root.left = buildTreeHelper(preStart+1, inStart, inIndex-1, preorder, inorder);
        // 右子树开头是preStart + (inIndex - inStart + 1)
        root.right = buildTreeHelper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
