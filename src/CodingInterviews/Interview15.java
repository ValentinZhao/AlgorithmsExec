package CodingInterviews;
/**
 * 链表中倒数第k个节点
 * @author zhaoziliang
 *
 */

public class Interview15 {
	class Node{
		int value;
		Node next;
	}
	
	public static Node KthNodeFromEnd(Node head, int k){
		if(head == null){
			return null;
		}
		Node frontNode = head;
		Node rearNode = null;
		for(int i = 0; i < k - 1; ++i){
			if(frontNode.next != null){
				frontNode = frontNode.next;
			} else {
				return null;
			}
		}
		rearNode = head;
		while(frontNode.next != null){
			frontNode = frontNode.next;
			rearNode = rearNode.next;
		}
		return rearNode;
	}
}
