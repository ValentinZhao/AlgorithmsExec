package lc834;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题意：给出一棵树，求出树上每个节点到其他节点的距离总和。
 *
 * 题解：每个节点保存两个值，一个是其子树的节点个数（包括自身节点也要计数）nodesum[]，一个是其子树各点到它的距离 dp[]
 * 那么我们假设根节点为 u ，其仅有一个儿子 v ， u 到 v 的距离为 1 ，而 v 有若干儿子节点，那么 dp[v] 表示 v 的子树各点到 v 的距离和
 * 那么各个节点到达 u 的距离便可以这样计算： dp[u] = dp[v] + nodesum[ v ] *1;
 * （式子的理解，v 的一个儿子节点为 f，那么 f 到达 u 的距离为
 * (sum[ f ->v] + sum [v- > u])*1
 * dp[v] 包含了 sum[f->v]*1 所以也就是式子的分配式推广到各个子节点计算出来的和）。
 * 我们已经知道了各个节点到达根节点的距离和，那么从根节点开始递推下来可以得到各个点的距离和。另开一个数组表示每个节点的到其他节点的距离和,
 * 那么对于根节点u来说， dissum[u] = dp[u]。
 * 以 u 的儿子 v 为例， v 的子节点到 v 不必经过 v->u 这条路径，因此 dissum[u] 多了 nodesum[v] * 1
 * 但是对于不是 v 的子节点的节点，只到达了 u ，因此要到达 v 必须多走 u->v 这条路径，因此 dissum[u] 少了 ( N - nodesum[v] ) * 1)
 * 所以 dissum[v] = dissum[u] - nodesum[v] * 1 + (N - nodesum[v] ) * 1，按照这个方法递推下去就可以得到各个点的距离和。
 */
public class Solution834 {
    int[] res, count;
    List<Set<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        count = new int[N];
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) tree.add(new HashSet<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        buildAllSubtreeNodeCountDFS(0, -1);
        buildAllNodeDistanceDFS(0, -1);
        return res;
    }

    private void buildAllSubtreeNodeCountDFS(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            buildAllSubtreeNodeCountDFS(i, root);
            count[root] += count[i];
            // 那么对于根节点root，所有子节点到root的和就是所有子节点到i节点的和
            // 再加上包括i节点本身在内的所有子节点个数 * 1，毕竟所有子节点都得经过i才能到达root
            res[root] += res[i] + count[i] * 1;
        }
        count[root]++;
    }

    private void buildAllNodeDistanceDFS(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            // z这里有两种情况
            // ①：一种是i是root的subtree里面的一员，这样的话root到i这步的话其实res[root]已经包括了所有情况了，但是
            // i到所有点的话，我们不需要再计算i到i的所有子节点的数量了，因为res[root]已经包括了（再次注意i在root的子树里面），所以我们减去i的所有子节点个数*1
            // ②：i不是root的subtree的一员，要想到达i还得走root到i这一步，那其实就是全部节点数减去i自己的节点数，就是从root到i的数量了
            res[i] = res[root] - count[i] * 1 + count.length - count[i];
            buildAllNodeDistanceDFS(i, root);
        }
    }
}
