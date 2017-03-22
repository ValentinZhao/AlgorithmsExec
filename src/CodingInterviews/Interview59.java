package CodingInterviews;

import CodingInterviews.Interview27.BinaryTreeNode;

/**
 * 对称的二叉树
 * @author zhaoziliang
 *
 */
public class Interview59 {
	public static boolean isSymmetrical(BinaryTreeNode root){
		if(root == null){
			return true;
		}
		return isSymmetricalCore(root.left, root.right);
	}

	private static boolean isSymmetricalCore(BinaryTreeNode left, BinaryTreeNode right) {
		if(left == null) return right == null;
		if(right == null) return false;
		if(left.value != right.value) return false;
		return isSymmetricalCore(left.right, right.left) && isSymmetricalCore(left.left, right.right);
	}
}
