package CodingInterviews;

import java.util.HashMap;

public class Interview5 {
	
	/**
	 *根据前中序序列来构造二叉树 
	 */
	public Node preInToTree(int[] pre, int[] in){
		if(pre == null || in == null){
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < in.length; i++){
			map.put(in[i], i);//在中序数组找到位置i
		}
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}
	
	private Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
		if(pi > pj){
			return null;
		}
		Node head = new Node(p[pi]);
		int index = map.get(p[pi]);
		head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
		head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
		return head;
	}

	class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int data){
			this.value = data;
		}
	}
}
