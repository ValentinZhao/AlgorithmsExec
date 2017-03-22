package CodingInterviews;

import CodingInterviews.Interview13.ListNode;

/**
 * 链表的入口节点
 * @author zhaoziliang
 *
 */
public class Interview56 {
	public static ListNode meetingNode(ListNode head){
		if(head == null){
			return null;
		}
		ListNode slow = head.next;
		if(slow == null){
			return null;
		}
		ListNode fast = slow.next;
		while(fast != null && slow != null){
			if(fast == slow){
				return fast;
			}
			slow = slow.next;
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
			}
		}
		return null;
	}
	
	public static ListNode entryOfLoop(ListNode head){
		if(head == null){
			return null;
		}
		ListNode meetingNode = meetingNode(head);
		int numOfNodeInLoop = 1;
		ListNode node1 = meetingNode;
		while(node1.next != meetingNode){
			node1 = node1.next;
			numOfNodeInLoop++;
		}
		node1 = head;
		for(int i = 0; i < numOfNodeInLoop; i++){
			node1 = node1.next;
		}
		ListNode node2 = head;
		while(node1 != node2){
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}
}
