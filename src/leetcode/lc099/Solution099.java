package lc099;

import TreeNode.TreeNode;

/**
 * 要你找一个BST中两个逆序了的点，把它们摆正然后返回修正后的BST
 * 这样的话由于BST的性质，我们可以先中序遍历，然后在遍历过程中找当前比上一个点更大的点，并记录下下一个点，最后进行swap
 * swap也不要想的复杂了，直接获得两个node的引用之后，交换value即可
 */
public class Solution099 {
    private TreeNode firstElement;
    private TreeNode secondElement;
    private TreeNode prevElement;

    public void recoverTree(TreeNode root) {
        prevElement = new TreeNode(Integer.MIN_VALUE);
        inorderTraversal(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (firstElement == null && prevElement.val >= root.val) firstElement = prevElement;
        if (firstElement != null && prevElement.val >= root.val) secondElement = root;
        prevElement = root;
        inorderTraversal(root.right);
    }
}


class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;

        // 注意这里是或！！不是与！！！
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;

                // 如果你交换两个node你至少需要找到两个，那么这两个node.val都是小于前面node.val的
                // 所以这里很巧妙就是说第一次找到时，x从null变为pred，此时还不需要退出因为要找第二个node，给到y
                // 所以就是当x有值的时候就退出了
                if (x == null) x = pred;
                else break;
            }

            pred = root;
            root = root.right;
        }

        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}