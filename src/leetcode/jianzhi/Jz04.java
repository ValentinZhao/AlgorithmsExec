package jianzhi;

import TreeNode.TreeNode;

public class Jz04 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;

        TreeNode root = new TreeNode(pre[startPre]);

        // 找前序遍历第一个值，在中序遍历中的位置index，那么index-startIn就是中序中左子树的部分，这个长度也就是前序中左子树的长度可以直接用
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                // 也就是说，前序遍历中的左子树起点是start的下一位，直到 中序遍历中的左子树长度 的终点
                // 中序遍历的左子树起点还是原来的起点（因为中序遍历中，左右子树就正好分立在root节点两侧的数组中），然后终点就正好是根节点前一位
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                // 也就是说，前序遍历中的右子树起点是endPre的下一位（因为前序遍历中，根节点在第一位剩下左右子树连在一起），直到原来的endStart
                // 中序遍历的右子树起点是原来的根节点下一位，然后终点就正好是原来的结尾
                root.right = reConstructBinaryTree(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
            }
        }

        return root;
    }
}
