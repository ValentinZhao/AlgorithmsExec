package jianzhi;

import TreeNode.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Jz61 {
    private static String spliter = ",";
    private static String occupier = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        doSerialize(root, builder);
        return builder.toString();
    }

    private void doSerialize(TreeNode root, StringBuilder builder) {
        if (root == null) builder.append(occupier).append(spliter);
        else {
            builder.append(root.val).append(spliter);
            doSerialize(root.left, builder);
            doSerialize(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return doDeserialize(nodes);
    }

    private TreeNode doDeserialize(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(occupier)) return null;
        else {
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = doDeserialize(nodes);
            root.right = doDeserialize(nodes);
            return root;
        }
    }
}
