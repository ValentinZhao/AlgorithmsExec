package lc111;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最短路径很明显BFS更加有效率，直接读到某层的叶子节点直接返回
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftLevel  = minDepth(root.left);
        int rightLevel = minDepth(root.right);
        if (leftLevel == 0 || rightLevel == 0) { // 有一边没有任何子树的时候，只能返回另一侧子树的高
            return Math.max(leftLevel, rightLevel) + 1;
        } else { // 两侧均有子树
            return Math.max(leftLevel, rightLevel) + 1;
        }
    }
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return level;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            level++;
        }
        return level;
    }

}
