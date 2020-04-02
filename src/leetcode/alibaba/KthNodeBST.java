package alibaba;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * BST的中序遍历,找第K个位置就好。递归非递归都能做，写个非递归的一般就没问题了
 */
public class KthNodeBST {
    public TreeNode getk(TreeNode root, int k) {

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (--k == 0) return root;
                root = root.right;
            }
        }

        return null;
    }
}
