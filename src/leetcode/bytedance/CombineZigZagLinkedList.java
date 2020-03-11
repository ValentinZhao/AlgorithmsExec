package bytedance;

import ListNode.ListNode;

/*
一个链表奇数位上升序，偶数位上降序，不用额外空间让这个链表整体升序
1->8->3->6->5->4->7->2->9

总体来说就是三步：首先把这个链表分到两个链表头上，按照奇偶的顺序分就好；然后把偶数链表整体逆转；最后把两个链表按照大小顺序接在一起
 */
public class CombineZigZagLinkedList {
    private static ListNode[] partite(ListNode head) {
        int count = 1;
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while (head != null) {
            if (count % 2 != 0) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
            count++;
        }
        cur1.next = null;
        cur2.next = null;

        return new ListNode[]{head1.next, head2.next};
    }

    private ListNode reverseList(ListNode head) {
        ListNode next = null, curr = head, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr; // 最后一步，处于末尾的curr给到prev，prev是最尾部，然后curr在下一行里变成null，所以最后返回prev
            curr = next;
        }
        return prev;
    }

    private static ListNode combine(ListNode l1, ListNode l2) {
        // dummy head是不动的，永远是新建一个cursor去动
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
        }

        return head.next;
    }
}
