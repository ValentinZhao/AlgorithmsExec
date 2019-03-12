package lc106;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 这题思路为，首先把inorder的数组-index使用map存起来，方便postorder便利的时候拿到对应inorder的index
 * 这个index就是我们用来分左右子树的重要节点，其次的话就是准确的切割preorder数组，再两边递归即可
 * dfs的推出条件是两指针相遇，还是蛮经典的dfs
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTreeInPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode buildTreeInPost(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) return null;
        int index = map.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildTreeInPost(inorder, inStart, index-1, postorder, postStart, postStart+index-inStart-1, map);
        root.right = buildTreeInPost(inorder, index+1, inEnd, postorder, postStart+index-inStart, postEnd-1, map);
        return root;
    }
}
