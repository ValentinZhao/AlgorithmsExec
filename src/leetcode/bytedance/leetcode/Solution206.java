package bytedance.leetcode;

import ListNode.ListNode;

public class Solution206 {
    public ListNode reverseListIter(ListNode head) {
        ListNode next, prev = null, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode reverseListRecur(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
