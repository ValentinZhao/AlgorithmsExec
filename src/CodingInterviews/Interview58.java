package CodingInterviews;

import org.w3c.dom.Node;

/**
 * 二叉树的下一个节点
 * @author zhaoziliang
 *
 */
/**
 * 那么根据规律，他的后一个节点是：
 * 1.如果有右子树，则是右子树的最左节点
 * 2.没有右子树，则找到第一个当前节点是父节点左孩子的节点
 * 3.这样还没有的话直接返回null
 * @author zhaoziliang
 *
 */
public class Interview58 {
	class TreeLinkNode{
		int value;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
	}
	
	public static TreeLinkNode getNextNode(TreeLinkNode root){
		if(root == null){
			return null;
		}
		if(root.right != null){
			root = root.right;
			while(root.right != null){
				root = root.left;
			}
			return root;
		}
		while(root.next != null){
			if(root.next.left == root){
				return root.next;
			}
			root = root.next;
		}
		return null;
	}
}
