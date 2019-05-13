package lc545;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 走一个leftBoundary, leaf, rightBoundary的流程
 */
public class Solution545 {
    private List<Integer> list = new ArrayList<>(1000);

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return list;
        list.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return list;
    }

    private void leftBoundary(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return;
        list.add(root.val);
        if (root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }

    private void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

    private void rightBoundary(TreeNode root) {
        if (root == null || root.right == null && root.left == null) return;
        if (root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        list.add(root.val); // 由于需要逆时针，右边是从子树开始塞入，再reverse回父节点
    }


}
