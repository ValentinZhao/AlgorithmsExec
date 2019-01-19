package src;


import lc002.Solution002.ListNode;
import lc053.Solution053;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        Solution053 solution = new Solution053();
        int[] data = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int test_int = 2356324;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(8);
//        ListNode res = solution.addTwoNumbers(l1, l2);
        int result = solution.maxSubArray(data);
        System.out.println("Input =====> " + Arrays.toString(data));
//        System.out.println("Input =====> " + test_int);
        System.out.println("Output =====> " + result);
//        while (res.next != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
//        System.out.println(res.val);
    }
}