package lc1110;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1110 {
    private Set<Integer> set;
    private List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int n : to_delete) set.add(n);
        dfs(root, true);
        return res;
    }

    // 只有当前节点是root，并且又没有被删的情况下，这个节点才是我们需要的
    private TreeNode dfs(TreeNode root, boolean isRoot) {
        if (root == null) return null;
        boolean deleted = set.contains(root.val);
        if (isRoot && !deleted) res.add(root);
        root.left = dfs(root.left, deleted);
        root.right = dfs(root.right, deleted);

        // 如果当前节点是被删掉的，就一定要返回null进行剪枝，否则直接返回自己
        // 所以这个dfs本身其实就是把自己轮训一遍，只是在过程中发现了待删节点就删掉，同时把下面的填入结果中
        // 这个利用isRoot和deleted来传递的思路太妙了
        return deleted ? null : root;
    }
}
