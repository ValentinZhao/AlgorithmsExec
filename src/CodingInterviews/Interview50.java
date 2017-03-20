package CodingInterviews;

import CodingInterviews.Interview27.BinaryTreeNode;

/**
 * 二叉树最低父节点
 * @author zhaoziliang
 *
 */
public class Interview50 {
	public static BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
		if(root == null){
			return null;
		}
		if(root == left || root == right){
			return root;
		}
		BinaryTreeNode rLeft = LCA(root.left, left, right);
		BinaryTreeNode rRight = LCA(root.right, left, right);
		if(rLeft != null && rRight != null){
			return root;
		}
		return (left != null) ? rLeft : rRight;
	}
}
