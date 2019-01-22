public class Solution141 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) { this.val = x; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode n1 = head, n2 = head;
        while (n2 != null) {
            n1 = n1.next;
            if (n2.next != null) n2 = n2.next.next;
            else break;
            if (n1 == n2) return true;
        }
        return false;
    }
}
