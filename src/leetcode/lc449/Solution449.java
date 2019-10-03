package lc449;

import TreeNode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 这道题跟297的区别是，这里的serialize是不需要给序列串塞入null的
 */
public class Solution449 {
    private static final String SEP = ",";
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        while (root != null) {
            builder.append(root.val).append(SEP);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == NULL) return null;
        String[] strs = data.split(SEP);
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
        // 简单来说，前面inorder的逻辑都一样个LC297，但建树的时候我们不需要记录null
        // 我们只需要跟root比较大小，小的一半推进一个queue，大的一半在另一个queue，再递归
        return buildBST(queue);
    }

    // some notes:
    //   5
    //  3 6
    // 2   7
    private TreeNode buildBST(Queue<String> queue) { //q: 5,3,2,6,7
        if (queue.isEmpty()) return null;
        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        Queue<String> smallerQueue = new LinkedList<>(); // 记录比root值小的队列
        while (!queue.isEmpty() && Integer.parseInt(queue.peek()) < root.val) {
            smallerQueue.offer(queue.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.left = buildBST(smallerQueue);
        //queue: 6,7   storing elements bigger than 5 (root)
        root.right = buildBST(queue);
        return root;
    }
}
