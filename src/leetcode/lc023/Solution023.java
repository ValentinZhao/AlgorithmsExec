package lc023;

public class Solution023 {
	public ListNode mergeKLists(ListNode[] lists){
		return partition(lists, 0, lists.length-1);
	}

	private ListNode partition(ListNode[] lists, int start, int end) {
		if (start == end) return lists[start];
		if (start < end) {
			int mid = (start + end) >> 1;
			ListNode node1 = partition(lists, start, mid);
			ListNode node2 = partition(lists, mid + 1, end);
			return mergeNodes(node1, node2);
		} else {
			return null;
		}
	}

	private ListNode mergeNodes(ListNode n1, ListNode n2) {
		// 以这句为例，上一轮递归传下来的是n1.next和n2，并且上一轮的n1的值更大，如果n1已经遍历完成，则把剩下来的那个n2插到最后
		// 因为上一轮递归是把这个方法的返回给了n1.next
		if (n1 == null) return n2;
		if (n2 == null) return n1;
		if (n1.val < n2.val) {
			n1.next = mergeNodes(n1.next, n2);
			return n1;
		} else {
			n2.next = mergeNodes(n1, n2.next);
			return n2;
		}
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { this.val = x; }
}