package lc515;

import TreeNode.TreeNode;

import java.util.*;

public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                maxValue = Math.max(maxValue, curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            list.add(maxValue);
        }
        return list;
    }
}
