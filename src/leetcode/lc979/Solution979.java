package lc979;

import TreeNode.TreeNode;

/**
 * DFS返回的是返回给父节点的金币的数量，可以是负数，表示金币由父节点传向子节点（其实只有可能是-1）
 */
public class Solution979 {
    int count = 0;
    public int distributeCoins(TreeNode root) {
        distributeCoinDFS(root);
        return count;
    }

    private int distributeCoinDFS(TreeNode root) {
        if (root == null) return 0;
        int left = distributeCoinDFS(root.left), right = distributeCoinDFS(root.right);
        count += Math.abs(left) + Math.abs(right);
        // 关于返回金币数量的公式可以自己列举出多个情况加以总结归纳
        /**
         *    3                      0
         *
         *  0   0 假如root是3...   3    0 假如root是顶部的0...
         *
         *  其实一句话解释就是我们假设所有被返回父节点的coins都要分出去，最后留一个金币给自己
         */
        return root.val + left + right - 1;
    }
}
