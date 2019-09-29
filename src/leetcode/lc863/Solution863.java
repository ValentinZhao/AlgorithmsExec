package lc863;

import TreeNode.TreeNode;

import java.util.*;

/**
 * 我们先计算出来从根节点到target节点的路径上所有节点到target的距离，存到map里面，然后再用dfs
 * 每次深入给这个已存的length+1，直到等于k，那么基于这样的机制，我们会发现越接近target的节点距离是越小的，也就是存的值很小
 * 这样就可以计算到穿过target向下的节点
 */
public class Solution863 {
    List<Integer> ans;
    Map<TreeNode, Integer> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        find(root, target);
        dfs(root, map.get(root), K);
        return ans;
    }

    private void dfs(TreeNode root, Integer distance, int K) {
        if (root == null) return;
        // 一般来讲，经过find函数的计算之后，所有包含target节点的这条path的父节点到target的距离都应该记录在map里面了
        // 那么只要是遍历到的是这些节点，我们就直接取出来这个distance，保证这个distance在这个阶段是不断减小的
        // 那么在穿过target向下，或者是一开始去到了不包含target的子树中向下，map中都是没有这些节点的，我们就直接不断+1，这就是本题的trick了
        if (map.containsKey(root)) distance = map.get(root);
        // 这里就算遇到了K也不return，方便穿过target继续向下
        if (distance == K) ans.add(root.val);
        dfs(root.left, distance + 1, K);
        dfs(root.right, distance + 1, K);
    }

    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
}

class Solution {
    private static Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        buildGraph(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        queue.offer(target);
        set.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                    return res;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode n : map.get(node)) {
                    if (set.contains(n)) continue;
                    set.add(n);
                    queue.offer(n);
                }
            }
            K--;
        }
        return res;
    }

    private void buildGraph(TreeNode root, TreeNode parent) {
        if (root == null) return;
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<>());
            if (parent != null) {
                map.get(root).add(parent);
                map.get(parent).add(root);
            }
        }
        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }
}

/**
 * 第三次写了，主要就注意一下buildGraph的写法，他是传child节点和自己到下一层
 * 连接的就是自己和parent的一个双向图
 * 只要parent或者当前node为空就不连接
 */
class Solution3 {
    private static Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        buildGraph(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        queue.offer(target);
        set.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                    return res;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode n : map.get(node)) {
                    if (set.contains(n)) continue;
                    set.add(n);
                    queue.offer(n);
                }
            }
            K--;
        }
        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
        }
        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }
}