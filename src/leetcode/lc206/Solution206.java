package lc206;

import lc002.Solution002;

public class Solution206 {
    // iterative
    public Solution002.ListNode reverseList(Solution002.ListNode head) {
        Solution002.ListNode newHead = null;
        while (head != null) {
            Solution002.ListNode next = head.next; // 保存next的内存位置
            head.next = newHead; // 把当前的head.next的内存位置指向一个新位置
            newHead = head; // 把这个新位置的区域指向head也就是当前节点的内存位置，此时head和newHead是共享同一个内存区的
            head = next; // head指针后移，上面的head.next由于跟随着newHead移动到了head位置，同时原本的head后移了，所以就把指针翻转了
        }
        return newHead;
    }
    // recursive
    public Solution002.ListNode reverseList2 (Solution002.ListNode head, Solution002.ListNode newHead) {
        if (head == null) return newHead;
        Solution002.ListNode next = head.next;
        head.next = newHead;
        return reverseList2(next, head);
    }
}
