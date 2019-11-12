package lc337;

import TreeNode.TreeNode;

/**
 * dfs的经典题，返回一个new int[2], nums[0]是rob当前节点的返回，那么既然rob当前节点了，left和right的接受都是要"不rob当前节点的返回值"
 * 也就是left[1] right[1]；那么nums[1]是不rob当前节点，他就直接返回left和right中结果较大的那个的和
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = robDFS(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robDFS(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robDFS(root.left);
        int[] right = robDFS(root.right);
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}

class Solution {
    public int rob(TreeNode root) {
        int[] res = robDFS(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robDFS(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = robDFS(root.left);
        int[] right = robDFS(root.right);

        res[0] = root.val + left[1] + right[1];
        // res[1]是不rob当前节点时，最大的收益，那么由于此点不rob，它的子节点可以选择rob或者依然也不rob，毕竟确实存在一种情况说第三个点比前两个点大得多
        // 那这时候应该是连续两次不rob转而rob第三家
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}