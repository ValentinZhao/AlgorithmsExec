import javax.swing.tree.TreeNode;

/**
 * Description:
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution674 {
    public boolean isUnivalTree(TreeNode root) {
        boolean isLeftValid = (root.left == null || (root.val == root.left.val &&                                              isUnivalTree(root.left)));
        boolean isRightValid = (root.right == null || (root.val == root.right.val &&
                isUnivalTree(root.right)));
        return isLeftValid && isRightValid;
    }
}