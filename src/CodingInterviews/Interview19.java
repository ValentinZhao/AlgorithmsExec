package CodingInterviews;
/**
 * 二叉树的镜像
 * @author zhaoziliang
 *
 */
public class Interview19 {
	class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static void mirrorRecursively(BinaryTreeNode head){
		if(head == null){
			return;
		}
		if(head.left == null && head.right == null){
			return;
		}
		//按照前序遍历翻转左右子树即可
		BinaryTreeNode tempNode = head.left;
		head.left = head.right;
		head.right = tempNode;
		if(head.left != null){
			mirrorRecursively(head.left);
		}
		if(head.right != null){
			mirrorRecursively(head.right);
		}
	}
}
