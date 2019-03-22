package lc143;

import ListNode.ListNode;

/**
 * 这题其实分三步很简单，第一步是把原链表分成两半，然后把后一半翻转，最后再把后一半依次插入前一半的每个元素之间即可
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode prev = null, slow = head, fast = head, l1 = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // 在这一步切断
        ListNode l2 = reverseList(slow);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode next = null, curr = head, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
