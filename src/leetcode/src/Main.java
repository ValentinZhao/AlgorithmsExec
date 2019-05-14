package src;


import TreeNode.TreeNode;
import lc002.Solution002.ListNode;
import lc035.Solution035;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
//        TreeNode root = generateSampleTreeNode();
//        Solution173.BSTIterator solution = new Solution173.BSTIterator(root);
        Solution035 solution = new Solution035();
        int[] data = new int[]{1,3,5};
//        String data = "2*3-4*5";
//        int[][] matrix = new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
//        int[][] matrix = new int[][]{{-1,3}};
        int [][] matrix = new int[][]{{0,0,0}, {0,1,0}, {1,1,1}};
//        String[][] tickets = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        String[] str_arr = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
//        Arrays.sort(str_arr);
        int test_int = 3;
//        ListNode l1 = generateSampleListNode();
//        ListNode l2 = generateSampleListNode();
//        ListNode res = solution.addTwoNumbers(l1, l2);
        int result = solution.searchInsert(data, 4);
        System.out.println("Input =====> " + Arrays.toString(data));
//        System.out.println("Input =====> " + Arrays.toString(matrix));
        System.out.println("Output =====> " + result);
//        System.out.println("=======INPUT=======");
//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        System.out.println("=======OUTPUT=======");
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(Arrays.toString(result[i]));
//        }
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