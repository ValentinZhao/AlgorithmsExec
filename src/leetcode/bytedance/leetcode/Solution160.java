package bytedance.leetcode;

import ListNode.ListNode;

public class Solution160 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1 = 0, l2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }
        int diff = Math.abs(l1 - l2);
        if (l1 > l2) {
            while (diff > 0) {
                pHead1 = pHead1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                pHead2 = pHead2.next;
                diff--;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }
}
