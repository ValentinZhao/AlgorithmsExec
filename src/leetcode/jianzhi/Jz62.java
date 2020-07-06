package jianzhi;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jz62 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0) return null;
        TreeNode p = pRoot;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (--k == 0) return p;
            p = p.right;
        }

        return null;
    }
}
