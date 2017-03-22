package CodingInterviews;

import CodingInterviews.Interview13.ListNode;

/**
 * 删除列表中重复的节点
 * @author zhaoziliang
 *
 */
public class Interview57 {
	public static void deleteDuplicatedNodes(ListNode head){
		if(head == null){
			return;
		}
		ListNode pre = null;
		ListNode node = head;
		while(node != null){
			ListNode nextNode = node.next;
			boolean needToDel = false;
			if(nextNode != null && nextNode.value == node.value){
				needToDel = true;
			}
			if(!needToDel){
				pre = node;
				node = node.next;
			} else {
				int value = node.value;
				ListNode toDel = node;
				while(toDel != null && toDel.value == value){
					nextNode = toDel.next;
					pre.next = nextNode;
					toDel = null;
					toDel = nextNode;
				}
				if(pre == null){
					head = nextNode;
				} else {
					pre.next = nextNode;
				}
				node = nextNode;
			}
		}
	}
}
