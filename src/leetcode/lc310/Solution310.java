package lc310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 这个题很优秀啊，是个好题。这个题给定的是个图，但是让我们构建成树，也就是说构建出来的并不是二叉树。
 *
 * 题目其实想考我们的是，整个图最靠近中间的节点是什么。我们使用类似与拓扑排序的BFS进行解决。
 *
 * 拓扑排序我们都知道，每次选择入度为0的节点进行删除。在这个题中，因为我们要找到无向图最靠近中间的节点
 * 所以，我们先使用一个字典保存每个节点的所有相邻节点set。每次把所有只有一个邻接的节点（叶子节点，类似于入度为0，但是这是个无向图，入度等于出度）都放入队列
 * 然后遍历队列中的节点u，把和每个节点u相邻的节点v的set删去u，所以这一步操作得到的是去除了叶子节点的新一轮的图。
 *
 * 所以我们需要再次进行选择只有一个邻接节点的叶子节点，然后放入队列中，再次操作
 *
 * **最后结束的标准是，整个图只留下了1个或者两个元素。**为什么不能是3个呢？因为题目第一句话说了给出的图是具有树的特性的，所以一定没有环存在。
 *
 * 这个题整体的思路就是把所有的叶子节点放入队列中，然后同时向**中间遍历**，这样最后剩下来的就是整棵树中间的元素。
 */
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<List<Integer>> graph = new ArrayList<>();
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) graph.add(i, new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degrees[u]++;
            degrees[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) return res;
            else if (degrees[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                res.add(curr);
                degrees[curr]--;
                for (int j = 0; j < graph.get(curr).size(); j++) {
                    int next = graph.get(curr).get(j);
                    if (degrees[next] == 0) continue;
                    if (degrees[next] == 2) queue.offer(next);
                    degrees[next]--;
                }
            }
        }
        return res;
    }
}
