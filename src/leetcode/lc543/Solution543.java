package lc543;

import TreeNode.TreeNode;

public class Solution543 {
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getLongerChild(root);
        return res;
    }

    private int getLongerChild(TreeNode root) {
        if (root == null) return 0;
        int left = getLongerChild(root.left);
        int right = getLongerChild(root.right);
        res = Math.max(res, left + right);
        // 如果想要通过递归叠加某变量，要加在return这里！！！
        // 我原来写成 1 + getLongerChild(root.left)，这是不对的，这是相当于得到结果后强行+1
        // 我们应该在出结果前 + 1
        return 1 + Math.max(left, right);
    }
}
