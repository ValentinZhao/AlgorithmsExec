package src;


import TreeNode.TreeNode;
import lc002.Solution002.ListNode;
import lc164.Solution164;

public class Main {
    public static void main (String[] args) {
//        TreeNode root = generateSampleTreeNode();
//        Solution173.BSTIterator solution = new Solution173.BSTIterator(root);
        Solution164 solution = new Solution164();
        int[] data = new int[]{13684,13701,15157,2344,28728,16001,9900,7367,30607,5408,17186,13230,1598,9766,13083,27618,29065,9171,2470,20163,5530,20665,14818,4743,24871,27852,8129,4071,17488,30904,1548,16408,1734,17271,19880,22269,18738,30242,6679,19867,13781,4615,10049,28877,9323,5373,11381,18489,13654,14324,28843,27010,10232,31696,29708,3008,28769,30840,21172,28461,20522,8745,17590,27936,30368,30993,24416,17472};
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
        int result = solution.maximumGap(data);
        System.out.println("Input =====> " + data);
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