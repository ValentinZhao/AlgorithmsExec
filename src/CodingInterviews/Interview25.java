package CodingInterviews;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * 二叉树中和为某一值的路径
 * @author zhaoziliang
 *
 */
public class Interview25 {
	class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static void findPath(BinaryTreeNode head, int target){
		if(head == null){
			return;
		}
		Stack<Integer> path = new Stack<>();
		int currentSum = 0;
		findPath(head, target, path, currentSum);
	}

	private static void findPath(BinaryTreeNode head, int target, Stack<Integer> path, int currentSum) {
		currentSum += head.value;
		path.push(head.value);
		boolean isLeaf = head.left == null && head.right == null;
		if(currentSum == target && isLeaf){
			for(int i : path){
				System.out.print(i + " ");
			}
			System.out.println("");
		}
		if(head.left != null){
			findPath(head.left, target, path, currentSum);
		}
		if(head.right != null){
			findPath(head.right, target, path, currentSum);
		}
		path.pop();//返回父节点前删除路径
	}
}
