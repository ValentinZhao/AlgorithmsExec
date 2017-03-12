package CodingInterviews;

/**
 * 按层打印二叉树
 */
import java.util.LinkedList;
import java.util.Queue;

public class Interview23 {
	class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static void printFromTopToBottom(BinaryTreeNode head){
		if(head == null){
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		BinaryTreeNode node = head;
		while(!queue.isEmpty()){
			head = queue.poll();
			if(head.left != null){
				queue.offer(head.left);
			}
			if(head.right != null){
				queue.offer(head.right);
			}
		}
	}
}
