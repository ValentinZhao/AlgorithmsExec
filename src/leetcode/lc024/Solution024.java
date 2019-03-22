package lc024;

import ListNode.ListNode;

/**
 * 用dummyhead保存最头部，每次分配两个节点curr.next和cur.next.next，要注意两点
 * 1. 这个current一开始是dummyhead，之后都是转换过的两个节点中的靠后的那个节点，所以我们
 * 依赖current来进行转换并不需要担心current自己会被转换
 * 2. 转换的顺序是，首先令current.next.next的next指针给到current.next的next指针
 * 然后current.next指向current.next.next的值，最后再令current.next.next指向current.next的值
 * 节点本身我们一开始就先存好，这样分配指针就很方便了
 * 在循环的最后我们把current往后推即可
 */
public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first; // 就在这一步相当于把待翻转节点之间的指向翻转了
            current = current.next.next;
        }
        return dummyHead.next;
    }
}
