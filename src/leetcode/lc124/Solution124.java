package lc124;

import TreeNode.TreeNode;

/**
 * 这个最长的一条path，她是可以从任何起点到任意一个叶子节点的，也就是说
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 从15作为起点，7作为终点的path拥有最大sum，15->20->7 = 42 return 42即可
 * 所以方法也很简单了，dfs找某个node的左右子树的和的较大值，返回该节点值与这个较大值的和给上层
 * 同时在这个过程中不断维护一个最大值，它是左右子树最大sum加当前节点值，避免一种情况比如上层node是一个负值
 * 那这时候最大值其实是在下面的max中
 *
 */
public class Solution124 {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumPathDown(root);
        return maxSum;
    }

    private int maxSumPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxSumPathDown(root.left));
        int right = Math.max(0, maxSumPathDown(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}

class Solution {
    private static int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        findGreaterSum(root);
        return maxValue;
    }

    private int findGreaterSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, findGreaterSum(root.left));
        int right = Math.max(0, findGreaterSum(root.right));
        // 计算路径和的时候，使用左+右+根的和
        maxValue = Math.max(maxValue, left + right + root.val);
        // 返回的时候，我们需要返回的是，左或右的较大值，毕竟在递归中
        // 我们最后也是分别给left和right来取最大值
        return Math.max(left, right) + root.val;
    }
}
