package lc958;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 想法很简单，就是一个complete的二叉树，在我们用BFS的层级遍历推入的时候，遇到的第一个null退出后
 * 它的后面不应该再有任何元素了
 */
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        while (!queue.isEmpty() && queue.peek() == null) queue.poll();

        return queue.isEmpty();
    }
}
