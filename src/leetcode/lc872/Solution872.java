package lc872;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        readLeafDFS(root1, list1);
        readLeafDFS(root2, list2);
        return list1.equals(list2);
    }

    private void readLeafDFS(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) list.add(root.val);
        if (root.left != null) readLeafDFS(root.left, list);
        if (root.right != null) readLeafDFS(root.right, list);
    }
}
