package lc865;

import TreeNode.TreeNode;
import javafx.util.Pair;

public class Solution865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deepest(root).getValue();
    }

    private Pair<Integer, TreeNode> deepest(TreeNode root) {
        if (root == null) return new Pair<>(0, null);

        Pair<Integer, TreeNode> left = deepest(root.left), right = deepest(root.right);
        int l = left.getKey(), r = right.getKey();
        int deepestHeight = Math.max(l, r);
        // 如果一样高，说明deepest node都在当前root的左右子树中，直接返回root本身
        // 如果左子树较高，那么返回左子树头。注意，此后left一直大于right所以这个左子树引用一直向上传递
        // 所以能得到最低deepest node ancestor
        TreeNode ancestor = l == r ? root : l > r ? left.getValue() : right.getValue();
        // 每向下一层都要加一
        return new Pair<>(deepestHeight + 1, ancestor);
    }

}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deepest(root).getValue();
    }

    private Pair<Integer, TreeNode> deepest(TreeNode root) {
        if (root == null) return new Pair<>(0, null);
        Pair<Integer, TreeNode> left = deepest(root.left);
        Pair<Integer, TreeNode> right = deepest(root.right);

        int l = left.getKey(), r = right.getKey();
        int deepestHeight = Math.max(l, r);
        TreeNode ancestor = l == r ? root : l > r ? left.getValue() : right.getValue();
        return new Pair<>(deepestHeight+1, ancestor);
    }
}