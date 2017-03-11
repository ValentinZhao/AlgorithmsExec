package CodingInterviews;
/**
 * 在O(1)时间内删除链表节点
 * @author zhaoziliang
 *
 */

public class Interview13 {
	class ListNode{
		int value;
		ListNode next;
	}
	
	public static void deleteNode(ListNode head, ListNode toBeDeleted){
		if(head == null || toBeDeleted == null){
			return;
		}
		if(toBeDeleted.next != null){//待删除的节点后面还有节点
			ListNode nTakeOver = toBeDeleted.next;
			toBeDeleted.value = nTakeOver.value;
			toBeDeleted.next = nTakeOver.next;
		} else if(head == toBeDeleted) {//只有一个头结点
			head = null;
			toBeDeleted = null;
		} else {//待删除的节点是多节点链表的尾节点
			ListNode node = head;
			while(node.next != toBeDeleted){
				node = node.next;
			}
			node = null;
		}
	}
}
