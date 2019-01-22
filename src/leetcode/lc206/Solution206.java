package lc206;

import lc002.Solution002;

public class Solution206 {
    // iterative
    public Solution002.ListNode reverseList(Solution002.ListNode head) {
        Solution002.ListNode newHead = null;
        while (head != null) {
            Solution002.ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    // recursive
    public Solution002.ListNode reverseList2 (Solution002.ListNode head, Solution002.ListNode newHead) {
        if (head == null) return newHead;
        Solution002.ListNode next = head.next;
        head.next = newHead;
        return reverseList2(next, head);
    }
}
