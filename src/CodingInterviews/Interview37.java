package CodingInterviews;
/**
 * 两个链表的公共节点
 * @author zhaoziliang
 *
 */
public class Interview37 {
	class ListNode{
		int value;
		ListNode next;
	}
	
	public static ListNode findCommonNode(ListNode head1, ListNode head2){
		if(head1 == null || head2 != null){
			return null;
		}
		int listLength1 = getLength(head1);
		int listLength2 = getLength(head2);
		int lengthDiff = 0;
		
		ListNode longListHead;
		ListNode shortListHead;
		if(listLength1 >= listLength2){
			longListHead = head1;
			shortListHead = head2;
			lengthDiff = listLength1 - listLength2;
		} else {
			longListHead = head2;
			shortListHead = head1;
			lengthDiff = listLength2 - listLength1;
		}
		for(int i = 0; i < lengthDiff; i++){
			longListHead = longListHead.next;
		}
		while(longListHead != null &&
				shortListHead != null &&
				longListHead != shortListHead){
			longListHead = longListHead.next;
			shortListHead = shortListHead.next;
		}
		return longListHead;
	}

	private static int getLength(ListNode head) {
		if(head == null){
			return 0;
		}
		int length = 0;
		while(head != null){
			head = head.next;
			length++;
		}
		return length;
	}
}
