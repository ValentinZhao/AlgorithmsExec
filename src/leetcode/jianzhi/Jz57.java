package jianzhi;


public class Jz57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) pNode = pNode.left;
            return pNode;
        }
        // 代码走到这，证明你是个右叶子节点，向上返回到某父节点，这个节点是他的父节点的左孩子，他就是下一个元素
        while (pNode.next !=null) {
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }

        return null;
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
