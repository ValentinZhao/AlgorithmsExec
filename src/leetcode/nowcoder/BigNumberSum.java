package nowcoder;

import ListNode.ListNode;

public class BigNumberSum {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode res = new ListNode(0);
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            if (head1 != null) {
                carry += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                carry += head2.val;
                head2 = head2.next;
            }

            res.next = new ListNode(carry / 10);
            carry %= 10;
            res = res.next;
        }

        res = reverse(res);
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
