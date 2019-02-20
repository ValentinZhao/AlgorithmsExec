package lc133;

import java.util.*;

/**
 * 解法分为DFS和BFS，DFS的话，思路就是首先克隆一个节点，全局使用map来记录访问过的节点，每访问够一个就存一个，然后遍历所有的边，对每个边的节点递归调用clone
 * 同时把返回条件就是当遇到存过的节点时就直接返回该节点，同时把所有邻居add给clone节点的neighbor属性，被插入的对象就是clone递归返回的，这样就完成了
 * clone头结点本身和所有neighbor的插入。总之回到递归的最上层，所有节点及其邻居都存过了，就返回最上层的clone过的节点
 *
 * BFS的话，还是那一套while+pop队列的做法，这里有点变形，首先还是使用map来存储访问过的节点，用node.label来初始化cloneNode，然后在while中
 * 每次都pop一个node，iterate所有neighbor，如果neighbor没存过map就存进去，同时记得把子节点（也就是neighbor）给推到队列里面
 * 最后记得取出map中的cloneNode，把这个neighbor给加到cloneNode的neighbor属性中
 */
public class Solution133 {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        map.put(clonedNode.label, clonedNode);
        for (UndirectedGraphNode neighbor: node.neighbors) clonedNode.neighbors.add(clone(neighbor));
        return clonedNode;
    }

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.pop();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return clone;
    }

    private class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}
