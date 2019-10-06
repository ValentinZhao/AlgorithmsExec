package lc025;

import ListNode.ListNode;

public class Solution025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        // 存在k个nodes
        if (count == k) {
            curr = reverseKGroup(curr, k);
            // 这时候，如果后面还有大于k个nodes，这个curr就是下个k nodes
            // 翻转过后的头，比如1 <- 2 <- 3中的1，他正好是当前K nodes的结尾的后一个node
            // 如果后面不足K个，他也是头，只不过没翻转
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }
}