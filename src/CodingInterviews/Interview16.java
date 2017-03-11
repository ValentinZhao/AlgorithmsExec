package CodingInterviews;

import CodingInterviews.Interview16.Node;

/**
 * 反转链表
 * @author zhaoziliang
 *
 */

public class Interview16 {
	class Node{
		int value;
		Node next;
	}
	
	public static Node reverseList(Node head){
		if(head == null){
			return null;
		}
		Node next = null;
		Node pre = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
