package lc549;

import TreeNode.TreeNode;

/**
 * 向左右递归，首先给每个node设置inr和dcr都为1，inr意为到目前node为止的最长递增长度，dcr意为到目前node为止的最长递减长度
 * 那么我们跟进到最底部的时候（遇到null的话两个值都为0）会向上返回，这时候会去比较返回前node.val和当前node.val的关系
 * 如果是连续的就在对应位置上+1，再去进行右子树递归或者向上返回这样子。Solution里面的slides非常直观！！
 */
public class Solution549 {
	private int maxLength = 0;
	public int longestConsecutive(TreeNode root) {
		longestPath(root);
		return maxLength;
	}

	private int[] longestPath(TreeNode node) {
		if (node == null) return new int[]{0, 0};

		int inr = 1, dcr = 1;
		if (node.left != null) {
			int[] left = longestPath(node.left);
			if (node.val == node.left.val - 1) inr = left[0] + 1;
			else if (node.val == node.left.val + 1) dcr = left[1] + 1;
		}

		if (node.right != null) {
			int[] right = longestPath(node.right);
			// 遍历右边的时候，由于左边先遍历过了，这时候可能会发现inr或者dcr就算不是1，可能也没有左边长
			// 那如果这时候只是复制左边的逻辑直接返回right[0] + 1，可能会得到一个更小的值，所以这时候要用max函数
			if (node.val == node.right.val - 1) inr = Math.max(inr, right[0]+1);
			else if (node.val == node.right.val + 1) dcr = Math.max(dcr, right[1]+1);
		}

		// 当前root节点在左右计算inr dcr时计算了两次，去掉一次
		maxLength = Math.max(maxLength, inr + dcr - 1);

		return new int[]{inr, dcr};
	}
}
