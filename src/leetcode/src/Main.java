package src;


import TreeNode.TreeNode;
import jianzhi.Jz27;
import lc002.Solution002.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        TreeNode root = generateSampleTreeNode();
        int[] data = new int[]{-2,1,2,-2,1,2};
//        String data = "2*3-4*5";
        int[][] matrix = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
//        int[][] matrix = new int[][]{{-1,3}};
//        int [][] matrix = new int[][]{{0,0,0}, {0,1,0}, {1,1,1}};
//        String[][] tickets = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        String[] str_arr = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        char[] datas = new char[]{'A','A','A','B','B','B'};
//        Arrays.sort(str_arr);
        int test_int = 3;
//        ListNode l2 = generateSampleListNode();
        Jz27 jz27 = new Jz27();
        ArrayList<String> res = jz27.Permutation("abc");
//        ListNode res = solution.addTwoNumbers(l1, l2);
//        String result = solution.findReplaceString("jjievdtjfb", new int[]{4,6,1}, new String[]{"md","tjgb","jf"}, new String[]{"foe", "oov", "e"});
        System.out.println("Input =====> " + Arrays.toString(datas));
//        System.out.println("Input =====> " + Arrays.toString(matrix));
//        AllSubsequence all = new AllSubsequence();
//        List<List<String>> res = solution.findLadders("hit", "cog", new HashSet<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
//        System.out.println("Result =====> " + res);
//        System.out.println("Output =====> " + Arrays.asList(result));
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