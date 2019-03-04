package src;


import TreeNode.TreeNode;
import lc002.Solution002.ListNode;
import lc152.Solution152;

public class Main {
    public static void main (String[] args) {
//        TreeNode root = generateSampleTreeNode();
//        Solution173.BSTIterator solution = new Solution173.BSTIterator(root);
        Solution152 solution = new Solution152();
        int[] data = new int[]{2,3,-2,4};
//        String[] str_arr = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
//        Arrays.sort(str_arr);
        int test_int = 3;
//        ListNode l1 = generateSampleListNode();
//        ListNode l2 = generateSampleListNode();
//        ListNode res = solution.addTwoNumbers(l1, l2);
        int result = solution.maxProduct(data);
//        System.out.println("Input =====> " + Arrays.toString(str_arr));
        System.out.println("Input =====> " + data);
        System.out.println("Output =====> " + result);
        System.out.println("Output =====> " + Math.sqrt(13));
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