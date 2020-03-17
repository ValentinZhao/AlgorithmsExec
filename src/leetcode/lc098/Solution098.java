package lc098;

import TreeNode.TreeNode;

import java.util.Stack;

public class Solution098 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 在这里把根节点，左子节点推入栈；在循环的下一周期，把右子节点推入栈，以此达到换边的作用，因为下一句会再次切换回左子节点
                // 所以这个栈就很重要，它储存的是根节点和他的所有左子节点以及左叶子节点对应的那个右子节点
                // 这就使得在pop的时候，pre是左子节点，root就是根节点；pre变为根节点之后root又变成了右子节点，所以下面的判断条件不用变，很巧妙
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBSTRecursive(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}
