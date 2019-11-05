package lc776;

import TreeNode.TreeNode;

public class Solution776 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] result = new TreeNode[2];
        if (root == null) return result;
        if (root.val <= V) { // 当根节点值小于等于V，这时候我们需要把所有的左子树（毕竟小于根节点值）和右子树中部分值（node.val介于根节点和V之间部分）放在result[0]
            TreeNode[] res = splitBST(root.right, V); // 这时候res[0]是所有节点介于root val和V之间的值，res[1]就是大于V的所有值
            result[1] = res[1];
            root.right = res[0]; // 补回给root.right
            result[0] = root;
        } else {
            TreeNode[] res = splitBST(root.left, V);
            result[0] = res[0];
            root.left = res[1];
            result[1] = root;
        }

        return result;
    }
}
