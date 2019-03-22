package lc328;

import ListNode.ListNode;


/**
 *   首先要理解
 *   head (no move)   evenHead (no move)
 *         |             |
 *     odd (cursor)   even (cursor)
 *         |             |
 *         v             v
 *         ---------------------->   ------------------->
 *         |                      | |                   |
 *         1     ----->  2 ----->  3  ----->  4  -----> 5 -----> 6
 *                       |                   ||                  |
 *                       --------------------> ------------------>
 *    也就是说利用odd和even把next编织好，再返回一直没动的头结点即可
 *    最后evenhead补在odd.next后面，最后返回head即可，因为head和evenhead全程没动
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
