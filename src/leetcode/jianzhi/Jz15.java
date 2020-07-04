package jianzhi;

import ListNode.ListNode;


/**
 * https://zhuanlan.zhihu.com/p/86745433 递归翻转链表和解析
 */
public class Jz15 {
    public ListNode reverse(ListNode listNode) {
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

    public ListNode reverseRecur(ListNode listNode) {
        if (listNode.next == null) return listNode;
        ListNode last = reverseRecur(listNode.next); // 已翻转的链表的头部其实就是，始源列表的尾部
        listNode.next.next = listNode; // 当前元素的next的元素的next指针，指向当前元素，也就是向前指
        listNode.next = null; // 当前next指空，方便一会儿指向前一个
        return last;
    }

    private ListNode successor = null;

    // 将链表的前 n 个节点反转（n <= 链表长度）
    public ListNode reverseN(ListNode head, int n) {
        // 在最后一个要翻转的节点处，保留向后的指针
        // 它用来我们退回到原链表第一位时，把第一位指向这个地址，这样就把
        // 前面N个翻转过来并接上原本剩余的链表
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        // 这一步在中间环节会把当前元素指向一个"错误"的位置，但其实没关系，退回上层递归会把当前元素的next指向前面
        // 但是当递归退到第一位的时候，这一句可以使得原链表head的next指向剩余链表首位
        head.next = successor;
        return last;
    }

    // 翻转任意m到n的元素
    // 思路非常简洁，比如说对于原始链表来说，头元素索引为1的话，那么就是翻转m到n的链表
    // 然而，对于第二个元素的话，那就是翻转m-1到n-1的链表；对第三个就是m-2到n-2...
    // 这样对第m-1个元素来说就是翻转1到n-m，这就是上一题的算法了
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


}
