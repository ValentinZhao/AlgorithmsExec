package lc272;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int lo = 0, hi = list.size() - k;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            double left = list.get(mid);
            double right = list.get(mid+k);
            if (Math.abs(left - target) > Math.abs(right - target)) {
                lo++; // 左边偏移的太多了，左边界向前
            } else {
                hi--; // vice versa
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = lo; i < lo + k; i++) res.add(list.get(i));
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
