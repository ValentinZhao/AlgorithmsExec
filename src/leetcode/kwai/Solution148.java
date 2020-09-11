package kwai;

import ListNode.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode tail) {
        if (head == tail) return;
        ListNode slow = head, fast = head.next;
        int pivot = head.val;
        while (fast != tail) {
            if (fast.val < pivot) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }

        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, tail);
    }

    private void swap(ListNode n1, ListNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList1(head);
        ListNode l2 = sortList1(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode pseudoHead = new ListNode(0), cursorNode = pseudoHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cursorNode.next = l2;
                l2 = l2.next;
            } else {
                cursorNode.next = l1;
                l1 = l1.next;
            }
            cursorNode = cursorNode.next;
        }
        // 上面的循环走完，只会有一个链表走空了，把另外一个没走空的（也就是说它剩下的节点值都比较大）后面那部分全补在后面
        cursorNode.next = l1 == null ? l2 : l1;
        return pseudoHead.next;
    }
}
