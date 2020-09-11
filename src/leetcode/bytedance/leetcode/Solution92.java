package bytedance.leetcode;

import ListNode.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;

        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode prevm = prev;
        while (i <= n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        prevm.next.next = curr; // prevm是开始倒转前，m-1位置的节点，倒转后，它的next是逆转后的结尾点，这个结尾应该去链接n+1位置的节点，而这个节点其实就是上面迭代后的curr
        prevm.next = prev; // 同理，prevm本身应该去链接原来n位置的节点，毕竟它已经变成翻转后的链表头了

        return dummy.next;
    }
}
