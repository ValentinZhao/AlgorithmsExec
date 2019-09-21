/**
求最少的点可以遍历所有点 举个例子：
给出有向图
1->2
2->3
3->4
1->5.
只要走到1，就可以从1走到剩余其他所有点，所以答案就是最少要走1个点

相似问题 LC323
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

 */
class Solution {
        private void search(Set<Integer> res, Map<Integer, Set<Integer>> nodes, int cur, int start,
                            Set<Integer> visited, Set<Integer> currVisited) {
            // 这个就是看当前递归栈中有没有访问过某点
            currVisited.add(cur);
            // 这个visit是在getMin方法中控制start的，如果一个节点入度大于零的话那它就不可能作为起始点了
            // 当在递归中访问到了，证明它是从某个点进入到该点的，入度不为零
            // 因为我们求的是从某个点出发的点可以走遍整个图的，并且该图是独立的
            // 该点就不行了，跳出该方法后也不会再从这个点开始
            visited.add(cur);
            for (int next : nodes.get(cur)) {
                // 如果结果集合中包括该点，这证明原来我们认为它是一个单独的图的入度为零的那个起始点
                // 那么现在从其他起始点也找到了这个点的话，说明入度并不为零，把它去掉
                if (res.contains(next) && next != start) {
                    res.remove(next);
                }
                if (!currVisited.contains(next)) {
                    search(res, nodes, next, start, visited, currVisited);
                }
            }
        }

        public List<Integer> getMin(int[][] edges, int n) {
            Map<Integer, Set<Integer>> nodes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nodes.put(i, new HashSet<>());
            }
            for (int[] edge : edges) {
                nodes.get(edge[0]).add(edge[1]);
            }

            Set<Integer> visited = new HashSet<>();
            Set<Integer> res = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    res.add(i);
                    visited.add(i);
                    search(res, nodes, i, i, visited, new HashSet<>());
                }
            }

            return new ArrayList<>(res);
        }
}