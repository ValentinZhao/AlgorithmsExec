package lc173;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution173 {
    public static class BSTIterator {
        Queue<Integer> queue;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    queue.offer(root.val);
                    root = root.right;
                }
            }
        }

        /** @return the next smallest number */
        public int next() {
            return this.queue.poll();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }
    }
}