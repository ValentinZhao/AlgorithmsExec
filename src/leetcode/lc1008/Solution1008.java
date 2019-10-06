package lc1008;

import TreeNode.TreeNode;

public class Solution1008 {
    private int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int upperBound) {
        /**
         * 当我们遍历完数组，或者是下一个即将读到的数比目前的root要大
         * 那么这个情况下的话我们直接返回null，也就是上层递归的左子树是null
         * 在上一层的递归中，会继续执行到root.right = helper()的部分
         * 它会把大数字给到右边
         */
        if (idx == preorder.length || preorder[idx] > upperBound) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = helper(preorder, root.val); // 所有低于当前bound的数都会被append到这里，否则就是null
        root.right = helper(preorder, upperBound);
        return root;
    }
}
