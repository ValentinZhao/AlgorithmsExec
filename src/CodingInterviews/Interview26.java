package CodingInterviews;

/**
 * 复杂链表的复制
 * @author zhaoziliang
 *
 */
public class Interview26 {
	static class ListNode{
		int value;
		ListNode next;
		ListNode sibling;
	}
	
	public static void main(String[] args){
		
	}
	
	public static void cloneNodes(ListNode head){
		ListNode node = head;
		while(node != null){
			ListNode cloneNode = new ListNode();
			cloneNode.value = node.value;
			cloneNode.next = node.next;
			cloneNode.sibling = null;
			node.next = cloneNode;
			node = cloneNode.next;
		}
	}
	
	/**
	 * 要复制给cloneNode的sibling是原node指向的sibling node的next节点
	 * 因为cloneNode的sibling也肯定是一个复制出来的节点
	 * @param head
	 */
	public static void cloneSiblings(ListNode head){
		ListNode node = head;
		while(node != null){
			ListNode cloneNode = node.next;
			if(node.sibling != null){
				cloneNode.sibling = node.sibling.next;
			}
			node = cloneNode.next;
		}
	}
	
	public ListNode reconnectNodes(ListNode head){
		ListNode node = head;
		ListNode cloneHead = null;
		ListNode cloneNode = null;
		if(node != null){
			cloneHead = cloneNode = node.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		//循环开始时，node指向的是第二个node，cloneNode指向的也是第二个cloneNode
		while(node != null){
			cloneNode.next = node.next;//把node指向clone的指针指向cloneNode的next，这样先把cloneNode接起来一对
			cloneNode = cloneNode.next;//把cloneNode向后移，这时候新的cloneNode的next还是一个node而不是cloneNode
			node.next = cloneNode.next;//那么这时候把cloneNode.next给node.next相当于又把node接起来一对
			node = node.next;//把node向后移一位，这时候node.next还是一个cloneNode，可以继续循环了
		}
		return cloneHead;
	}
}
