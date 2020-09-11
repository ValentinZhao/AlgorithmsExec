package kwai;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    int count = 0;
    int target = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode root, int curr) {
        if (root == null) return;
        curr += root.val;

        if (curr == target) count++;

        count += map.getOrDefault(curr - target, 0);

        map.put(curr, map.getOrDefault(curr, 0) + 1);

        preorder(root.left, curr);
        preorder(root.right, curr);

        map.put(curr, map.get(curr) - 1);
    }
}
