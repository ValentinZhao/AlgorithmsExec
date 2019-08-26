package lc108;

import TreeNode.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return toBST(nums, 0, n-1);
    }

    private TreeNode toBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[start]);
        // 由于退栈条件是start>end而不是>=，所以我们在入递归栈的时候就传入+1-1这样子
        root.left = toBST(nums, start, mid - 1);
        root.right = toBST(nums, mid + 1, end);
        return root;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return toBST(nums, 0, n-1);
    }

    private TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[left]);
        root.left = toBST(nums, left, mid - 1);
        root.right = toBST(nums, mid + 1, right);
        return root;
    }
}