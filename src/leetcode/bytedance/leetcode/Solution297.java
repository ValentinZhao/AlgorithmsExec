package bytedance.leetcode;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution297 {
    private static String occupier = "#";
    private static String splitter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerial(root, sb);
        return sb.toString();
    }

    private void doSerial(TreeNode root, StringBuilder builder) {
        if (root == null) builder.append(occupier).append(splitter);
        else {
            builder.append(root.val).append(splitter);
            doSerial(root.left, builder);
            doSerial(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(data.split(splitter)));
        return doDeserial(queue);
    }

    private TreeNode doDeserial(Deque<String> queue) {
        String val = queue.remove();
        if (val.equals(occupier)) return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = doDeserial(queue);
            root.right = doDeserial(queue);
            return root;
        }
    }
}
