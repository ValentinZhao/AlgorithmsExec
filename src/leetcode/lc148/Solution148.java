package lc148;

import ListNode.ListNode;

/**
 * 规定了时间复杂度为O(nlogn)的话其实就是考归并排序啦，归并排序的简介讲解在这里
 *
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 * 由于现在是链表，我们分成两段的方式就是用快慢指针来找中间点，然后把prev.next = null即可断开
 */

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeList(l1, l2);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
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
