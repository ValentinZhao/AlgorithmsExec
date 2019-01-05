/**
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curP = root;
        TreeLinkNode nextDummyHead = new TreeLinkNode(0);
        TreeLinkNode p = nextDummyHead;
        while (curP != null) {
            if (curP.left != null) {
                p.next = curP.left;
                p = p.next;
            }
            if (curP.right != null) {
                p.next = curP.right;
                p = p.next;
            }
            if (curP.next != null) {
                curP = curP.next;
            }
            else {
                curP = nextDummyHead.next;
                nextDummyHead.next = null;
                p = nextDummyHead;
            }
        }
    }
}