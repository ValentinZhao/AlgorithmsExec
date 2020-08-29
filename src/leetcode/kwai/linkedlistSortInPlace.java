package kwai;

import ListNode.ListNode;

public class linkedlistSortInPlace {
    ListNode sort; // 先使用一个链表头准备插入

    public void sortlist(ListNode head) {
        sort = null;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode next = curr.next; // 一个一个遍历节点来插入
            insertSort(curr); // 插入方法逻辑
            curr = next; // 向后移动
        }
    }

    private void insertSort(ListNode newNode) {
        if (sort == null || newNode.val < sort.val) { // 新链表未初始化，或者传入接点是最小时，更新链表头为新节点
            newNode.next = sort;
            sort = newNode;
        } else {
            ListNode cur = sort;
            while (cur.next != null && cur.val < newNode.val) { // 不然，向后一直找新节点合适的位置
                cur = cur.next;
            }
            newNode.next = cur.next; // 链表插入操作
            cur.next = newNode;
        }
    }
}
