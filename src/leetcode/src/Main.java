package src;


import lc002.Solution002.ListNode;
import lc046.Solution046;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        Solution046 solution = new Solution046();
        int[] data = new int[]{1,2,3};
        String[] str_arr = new String[]{"abb", "bab", "abbb", "cvv"};
        Arrays.sort(str_arr);
        int test_int = 2356324;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(8);
//        ListNode res = solution.addTwoNumbers(l1, l2);
        List<List<Integer>> result = solution.permute(data);
        System.out.println("Input =====> " + Arrays.toString(data));
//        System.out.println("Input =====> " + test_int);
        System.out.println("Output =====> " + result);
//        System.out.println(Arrays.toString(str_arr));
//        while (res.next != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
//        System.out.println(res.val);
//        int[] ca = new int[]{1,2,3,4};
//        String keyStr = String.valueOf(ca);
//        System.out.println("Output =====> " + keyStr);
    }
}