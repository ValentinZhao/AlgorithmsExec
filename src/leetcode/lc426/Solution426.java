package lc426;

/**
 * 题意是将BST转换成循环双向链表，这样我们还是利用中序遍历，维护first和last两个node，然后在移动过程中不断连接当前node和previous的node
 * 这个时候要记得不断更新last
 * 最后再把first和last连接起来，done~
 */
public class Solution426 {
    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {
        inorderConnect(root);
        last.right = first;
        first.left = last;
        return first;
    }

    private void inorderConnect(Node root) {
        if (root != null) {
            inorderConnect(root.left);
            if (last != null) {
                last.right = root;
                root.left = last;
            } else {
                first = root;

            }
            last = root;
            inorderConnect(root.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
