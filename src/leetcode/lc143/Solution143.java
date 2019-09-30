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

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode n2 = reverseLinkedList(slow);
        mergeList(head, n2);
    }

    // n1肯定比n2多一位或者相等长度
    // 所以不用特别检测n2是不是null
    private void mergeList(ListNode n1, ListNode n2) {
        while (n1 != null) {
            ListNode next1 = n1.next, next2 = n2.next;
            n1.next = n2;
            if (next1 == null) break;
            n2.next = next1;
            n1 = next1;
            n2 = next2;
        }
    }

    private ListNode reverseLinkedList(ListNode root) {
        ListNode prev = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        return prev;
    }
}