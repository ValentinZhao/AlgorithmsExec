package lc107;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 这题我们来复习一下层级遍历的BFS和DFS写法
 */
public class Solution107 {
    // BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> nestedList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.peek().val);
            }
            nestedList.add(0, list); // 从双向链表的链表头插入
        }
        return nestedList;
    }

    // DFS,通过递归维护一个进栈层级数
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelOrderBottomDFS(wrapList, root, 0);
        return wrapList;
    }

    private void levelOrderBottomDFS(List<List<Integer>> wrapList, TreeNode root, int level) {
        if (root == null) return;
        // 我们看到level这个东西并不能直接计数，而是需要到某个程度由容器去记录，因为int是按照值传递的，并不保存引用
        // 递归栈跳出时level都是本层的那个值，并不能拿来做什么，但是他可以记录递归栈的深度，用这个深度来做一些业务是可以的
        if (level >= wrapList.size()) wrapList.add(0, new LinkedList<Integer>()); // 进入到下一层了，补一个list
        levelOrderBottomDFS(wrapList, root.left, level + 1);
        levelOrderBottomDFS(wrapList, root.right, level + 1);
        wrapList.get(wrapList.size() - level - 1).add(root.val); // 反着插入列表
    }
}
