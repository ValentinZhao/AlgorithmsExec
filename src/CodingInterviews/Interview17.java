package CodingInterviews;

/**
 * 合并两个排序的链表
 * @author zhaoziliang
 *
 */
public class Interview17 {
	class Node{
		int value;
		Node next;
	}
	
	public static Node mergeSortedLists(Node head1, Node head2){
		if(head1 == null){
			return head2;
		} else if(head2 == null){
			return head1;
		}
		Node mergeHead = null;
		if(head1.value < head2.value){
			mergeHead = head1;
			mergeHead.next = mergeSortedLists(head1.next, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = mergeSortedLists(head1, head2.next);
		}
		return mergeHead;
	}
}
