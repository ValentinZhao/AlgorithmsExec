package lc437;

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

    private void preorder(TreeNode root, int currSum) {
        if (root == null) return;
        currSum += root.val;
        if (currSum == target) count++;

        count += map.getOrDefault(currSum-target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        preorder(root.left, currSum);
        preorder(root.right, currSum);

        map.put(currSum, map.get(currSum)-1);
    }
}