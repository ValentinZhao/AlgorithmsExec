package lc142;

import ListNode.ListNode;

/**
 * 找链表成环位置的那个节点，首先是快慢节点找相遇位置，然后令一个指针归零，以相同速度前进，再次相遇的位置就是起始点
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != head) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
