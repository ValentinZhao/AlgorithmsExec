package CodingInterviews;
/**
 * 二叉树的深度、判断是否为BST
 * @author zhaoziliang
 *
 */
public class Interview39 {
	public static boolean isBalanced = false;
	class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static int treeDepth(BinaryTreeNode root){
		if(root == null){
			return 0;
		}
		int leftDepth = treeDepth(root.left);
		int rightDepth = treeDepth(root.right);
		
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}
	
	public boolean isBalanced(BinaryTreeNode root){
		isBalancedCore(root);
		return isBalanced;
	}

	private int isBalancedCore(BinaryTreeNode root) {
		if(root == null){
			return 0;
		}
		int leftDepth = isBalancedCore(root.left);
		int rightDepth = isBalancedCore(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1){
			isBalanced = true;
		}
		
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}
}
