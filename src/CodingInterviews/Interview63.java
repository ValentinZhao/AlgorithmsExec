package CodingInterviews;

import java.util.Stack;

import CodingInterviews.Interview27.BinaryTreeNode;

/**
 * 二叉搜索树的第k个结点
 * @author zhaoziliang
 *
 */
public class Interview63 {
	public static int count = 0;
	public static BinaryTreeNode kthNode(BinaryTreeNode head, int k){
		if(count > k || head == null){
			return null;
		}
		BinaryTreeNode p = head;
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode kNode = null;
		while(p != null || !stack.isEmpty()){
			while(p != null){
				stack.push(p);
				p = p.left;
			}
			BinaryTreeNode node = stack.pop();
			count++;
			if(count == k){
				kNode = node;
			}
			p = node.right;
		}
		return kNode;
	}
}
