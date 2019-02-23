package src;


import TreeNode.TreeNode;
import lc002.Solution002.ListNode;
import lc173.Solution173;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        TreeNode root = generateSampleTreeNode();
        Solution173.BSTIterator solution = new Solution173.BSTIterator(root);
        int[] data = new int[]{10,9,2,5,3,7,101,18};
        String[] str_arr = new String[]{"abb", "bab", "abbb", "cvv"};
        Arrays.sort(str_arr);
        int test_int = 3;
        ListNode l1 = generateSampleListNode();
        ListNode l2 = generateSampleListNode();
//        ListNode res = solution.addTwoNumbers(l1, l2);
//        boolean result = solution.isPalindrome("A man, a plan, a canal: Panama");
        while (solution.hasNext()) {
            int result = solution.next();
            System.out.println("Output =====> " + result);
        }
//        System.out.println("Input =====> " + Arrays.toString(data));
//        System.out.println("Input =====> " + test_int);
//        System.out.println("Output =====> " + result);
//        while (res.next != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }
//        System.out.println(res.val);
//        int[] ca = new int[]{1,2,3,4};
//        String keyStr = String.valueOf(ca);
//        System.out.println("Output =====> " + keyStr);
    }

    private static ListNode generateSampleListNode() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(8);
        return l1;
    }

    private static TreeNode generateSampleTreeNode() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        return root;
    }
}