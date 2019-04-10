package lc315;

import SegTreeNode.SegTreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 这题我们使用线段树来做，凡是涉及到"在一段序列，数组中取一个最大最小"这种题目，都可以用线段树来做
 * 那么本题主要就是难在implement一个线段树，做出线段树之后，我们直接用query方法来找数组每一位的数字，返回其count
 * count是我们给原始线段树的一个自定义属性，他记录了这个线段树节点被访问了几次，其实就是有几个数小于被query节点
 */
public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = num < min ? num : min;
            max = num > max ? num : max;
        }
        SegTreeNode root = new SegTreeNode(min, max);
        for (int i = nums.length-1; i >= 0 ; i--) {
            list.add(0, query(nums[i]-1, root)); // 减一，避免有重复的值
            update(nums[i], root);
        }
        return list;
    }

    private void update(int num, SegTreeNode root) {
        if (num < root.min || num > root.max) return;
        root.count++;
        if (root.max == root.min) return; // 遍历到了叶子节点，但是count还是要增加的，所以在这里return
        int mid = root.mid();
        if (num < mid) {
            if (root.left == null) root.left = new SegTreeNode(root.min, mid - 1);
            update(num, root.left);
        } else {
            if (root.right == null) root.right = new SegTreeNode(mid, root.max);
            update(num, root.right);
        }
    }

    private int query(int x, SegTreeNode root) {
        if (root == null) return 0;
        if (x >= root.max) {
            return root.count;
        } else {
            int mid = root.mid();
            if (x < mid) {
                return query(x, root.left);
            } else {
                return query(x, root.left) + query(x, root.right);
            }
        }
    }
}
