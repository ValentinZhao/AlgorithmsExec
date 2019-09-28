package lc314;

import TreeNode.TreeNode;

import java.util.*;

/**
 * 思路非常straightforward，使用BFS遍历的过程中维护一个column的队列来记录列数
 * 同时在poll的时候把列作为bucket维护同一列的node，同时维护两个边界，最后利用边界遍历一次即可
 */
public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.offer(root);
        cols.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if (root.left != null) {
                queue.offer(root.left);
                cols.offer(col - 1);
                min = Math.min(min, col-1);
            }
            if (root.right != null) {
                queue.offer(root.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}


// 简单来说就是永cols完整映射queue而已
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // col -> list
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int min = 0, max = 0;
        // 就是保证queue和col是同步的，poll出一个node的同时，也poll出一个col
        // 其实也可以用一个queue，维护一个pair，不过都一样（这是我最开始的想法）
        queue.offer(root);
        cols.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                cols.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        // 要包括max，毕竟max这一列也是被记录过的
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}