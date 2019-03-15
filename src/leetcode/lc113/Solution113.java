package lc113;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    private List<List<Integer>> list = new LinkedList<>();
    private LinkedList<Integer> tempList  = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        readSumPathDFS(root, sum, tempList);
        return list;
    }

    private void readSumPathDFS(TreeNode root, int sum, LinkedList<Integer> tempList) {
        if (root == null) return;
        tempList.add(root.val);
        // 这里注意了。。遍历到最后一个点sum==root.val而不是sum==0，写的太快这里忽略了= =
        if (sum == root.val && root.left == null && root.right == null) {
            // 这里不能直接插入tempList，因为其实是插入了引用，要复制一份进去才行，否则到最后全都是空的
            list.add(new LinkedList<>(tempList));
            tempList.removeLast();
            return;
        }
        readSumPathDFS(root.left, sum - root.val, tempList);
        readSumPathDFS(root.right, sum - root.val, tempList);
        tempList.removeLast();
    }
}
