package lc095;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildBSTList(1, n);
    }

    private List<TreeNode> buildBSTList(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) return list;
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = buildBSTList(start, i-1);
            right = buildBSTList(i+1, end);
            for (TreeNode nodeL : left) {
                for (TreeNode nodeR : right) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = nodeL;
                    curr.right = nodeR;
                    list.add(curr);
                }
            }
        }
        return list;
    }
}
