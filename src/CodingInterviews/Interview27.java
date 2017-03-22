package CodingInterviews;
/**
 * 二叉搜索树与双向链表
 * @author zhaoziliang
 *
 */
public class Interview27 {
	static class BinaryTreeNode{
		public BinaryTreeNode(Integer valueOf) {
			this.value = valueOf;
		}
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static BinaryTreeNode convert(BinaryTreeNode head){
		if(head == null){
			return null;
		}
		if(head.left == null && head.right == null){
			return head;
		}
		BinaryTreeNode left = convert(head.left);
		BinaryTreeNode p = left;
		while(p != null && p.right != null){
			p = p.right;
		}
		if(left != null){
			p.right = head;
			head.left = p;
		}
		BinaryTreeNode right = convert(head.right);
		if(right != null){
			right.left = head;
			head.right = right;
		}
		return left != null ? left : head;
	}
}
