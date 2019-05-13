package lc662;

import TreeNode.TreeNode;

import java.util.ArrayList;

/**
 * 我觉得是挺好的一道题，使用dfs记录下每层第一个被遍历到的节点作为左侧边界，然后用这一层的level作为key来保存
 * 每次dfs到这一层，就通过这一层的节点的index减去左侧节点就能计算出span，那么每一层任一节点的index怎样计算？有这样的公式
 *
 *           root: i
 * left:i * 2   right: i * 2 + 1
 */
public class Solution662 {
    private int max = 0;

    public int widthOfBinaryTree(TreeNode root) {
        readWidthBinaryTreeDFS(root, new ArrayList<Integer>(), 0, 0);
        return max;
    }

    private void readWidthBinaryTreeDFS(TreeNode root, ArrayList<Integer> lefts, int level, int pos) {
        if (root == null) return;
        if (lefts.size() == level) lefts.add(pos);
        // 这里面的一个小trick就是，level正好也是从0开始的正整数，正好对应了lefts.size的增长，这样只要记录level层级就能记录本层第一个被遍历到的元素
        // 又因为是一个先序遍历的顺序，所以左子树的叶子节点总能被率先遍历到
        max = Math.max(max, pos - lefts.get(level) + 1);
        readWidthBinaryTreeDFS(root.left, lefts, level + 1, pos * 2);
        readWidthBinaryTreeDFS(root.right, lefts, level + 1, pos * 2 + 1);
    }
}
