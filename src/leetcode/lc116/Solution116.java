package lc116;

/**
 * 同一层内，左子树的最右子节点和右子树的最左子节点连接起来的方式是，使用父节点的next进行跳跃，然后再把
 * cur.next.left给到cur.right.next即可
 */
public class Solution116 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node pre = root;
        Node cur = null;
        while (pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node(int x) { val = x; }
    }
}
