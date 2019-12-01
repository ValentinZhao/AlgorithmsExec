package lc117;

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
public class Solution117 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curP = root;
        TreeLinkNode nextDummyHead = new TreeLinkNode(0);
        TreeLinkNode p = nextDummyHead;
        while (curP != null) {
            if (curP.left != null) {
                // 这一行十分重要，它使得p向下移动了一行
                // 因为一开始p是任意创建的node，p.next直接指向了cur.left的话，cur一开始是root
                // 那么这就把p直接放在了cur.left的左侧，也就是 下一层最左节点的左边
                // 再深入说，p永远在curP的下面一层，dummy永远在curP下面一层最左节点的左面保持位置
                // 准备换行时给p提供指针（第55行）
                p.next = curP.left;
                p = p.next;
            }
            if (curP.right != null) {
                p.next = curP.right;
                p = p.next;
            }
            // curP的next是上一层已经建立好的，那么我们就直接向右这样子遍历
            if (curP.next != null) {
                curP = curP.next;
            }
            else {
                // p到最后就是指向了那一层最后一位，所以当这层遍历之后要把p更新到下一层
                // p到dummyHead使用引用传递
                curP = nextDummyHead.next;
                nextDummyHead.next = null;
                p = nextDummyHead;
            }
        }
    }
}

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }