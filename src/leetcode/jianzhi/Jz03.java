package jianzhi;

import ListNode.ListNode;

import java.util.ArrayList;

public class Jz03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = reverse(listNode);
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }

    private ListNode reverse(ListNode listNode) {
        ListNode next = null, prev = null, curr = listNode;
        while (curr != null) {
            next = curr.next; // 保存下一个元素的位置
            curr.next = prev; // 指针向前
            prev = curr; // prev向右移
            curr = next; // curr右移
        }
        // 最后curr在最后一个元素next之后变空，prev是最后一个元素，也是逆转后的头
        return prev;
    }
}
