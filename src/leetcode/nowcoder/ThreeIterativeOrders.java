package nowcoder;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ThreeIterativeOrders {
    public int[][] threeOrders (TreeNode root) {
        // write code here
        Integer[] preorder = preOrder(root);
        Integer[] inorder = inOrder(root);
        Integer[] postorder = postOrder(root);
        int len = preorder.length;
        int[][] res = new int[3][len];
        for (int i = 0; i < len; i++) {
            res[0][i] = preorder[i];
        }
        for (int i = 0; i < len; i++) {
            res[1][i] = inorder[i];
        }
        for (int i = 0; i < len; i++) {
            res[2][i] = postorder[i];
        }

        return res;
    }

    private Integer[] preOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root.left != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        return res.toArray(new Integer[res.size()]);
    }

    private Integer[] inOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res.toArray(new Integer[res.size()]);
    }

    private Integer[] postOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root.right != null) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                res.add(0, root.val);
                root = root.left;
            }
        }

        return res.toArray(new Integer[res.size()]);
    }
}
