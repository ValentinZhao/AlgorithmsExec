package lc559;

import java.util.List;

public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int cur = 0;
        for (Node node : root.children) {
            cur = Math.max(cur, maxDepth(node));
        }
        return 1 + cur;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
