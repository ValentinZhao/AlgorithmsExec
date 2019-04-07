package lc366;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<>();
        if (root == null) return leavesList;
        List<Integer> leaves = new ArrayList<>();
        while (root != null) {
            if (isLeave(root, leaves)) root = null;
            leavesList.add(leaves);
            leaves = new ArrayList<>();
        }
        return leavesList;
    }

    private boolean isLeave(TreeNode root, List<Integer> leaves) {
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return true;
        }
        if (root.left != null) {
            if (isLeave(root.left, leaves)) root.left = null;
        }
        if (root.right != null) {
            if (isLeave(root.right, leaves)) root.right = null;
        }
        return false;
    }
}
