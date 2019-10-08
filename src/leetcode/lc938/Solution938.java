package lc938;

import TreeNode.TreeNode;

public class Solution938 {
    // 就是利用DFS，不断递归两边，只要值处于两个值之间就可以了
    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        dfs(root, ans, L, R);
        return ans;
    }

    private void dfs(TreeNode root, int ans, int l, int r) {
        if (root.val <= r && root.val >= l) ans += root.val;
        if (root.val <= r) dfs(root.right, ans, l, r);
        if (root.val >= l) dfs(root.left, ans, l, r);
    }
}
