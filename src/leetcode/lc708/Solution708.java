package lc708;

public class Solution708 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal, null);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node pre = head;
        Node next = head.next;
        while (next != head) {
            int preVal = head.val;
            int nextVal = next.val;
            // 原题是整个链表是上升排序的
            // 当你遇到两个点是降序的
            // 那么他们必然是即将到达head之前的点了（pre是尾部最大值，next降下去）
            // 那么这时候也可以把node插入到他们之间，但要保证node是比prev还要大的
            // 或者比next还要小，这都能让链表环依然有序
            if (preVal <= insertVal && insertVal < nextVal ||
                nextVal < preVal && preVal <= insertVal ||
                insertVal <= nextVal && nextVal < preVal) break;
            pre = next;
            next = next.next;
        }

        pre.next = node;
        node.next = next;
        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};