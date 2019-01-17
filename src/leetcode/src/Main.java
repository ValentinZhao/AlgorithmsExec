package src;


import lc002.Solution002.ListNode;
import lc005.Solution005;

public class Main {
    public static void main (String[] args) {
        Solution005 solution = new Solution005();
        int[] data = new int[]{5,4,3,2,1};
        String test_int = "abb";
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(8);
//        ListNode res = solution.addTwoNumbers(l1, l2);
        String result = solution.longestPalindrome(test_int);
//        System.out.println("Input =====> " + Arrays.toString(data));
        System.out.println("Input =====> " + test_int);
        System.out.println("Output =====> " + result);
//        while (res.next != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
//        System.out.println(res.val);
    }
}