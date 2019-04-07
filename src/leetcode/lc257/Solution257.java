package lc257;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        buildPaths(root, "", list);
        return list;
    }

    private void buildPaths(TreeNode root, String path, List<String> list) {
        if (root.left == null && root.right == null) list.add(path + root.val);
        if (root.left != null) buildPaths(root.left, path+root.val+"->", list);
        if (root.right != null) buildPaths(root.right, path+root.val+"->", list);
    }
}
