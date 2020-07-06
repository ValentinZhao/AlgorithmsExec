package jianzhi;

import ListNode.ListNode;

public class Jz56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead; // 只有0个或1个结点，则返回

        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
            while (pNode != null && pNode.val == pHead.val) pNode = pNode.next;
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(pNode);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead==null || pHead.next==null) return pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
