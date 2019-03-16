package lc120;

import java.util.List;

/**
 * 很明显bottom up的dp题，非常好的一道题
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        // 先用最下面一行填满dp数组，毕竟自底向上我们得把所有元素都遍历一次
        for (int i = 0; i < m; i++) dp[i] = triangle.get(m-1).get(i);
        // 接下来就是dp[i]是代表自底部到i这行的minimum sum的值
        // 上一行元素，比如说a[i]，那么他在下一行的左节点index也是i，右节点是i+1（直接写，不用检查越界，因为下一行元素总比上一行多1），这个很重要！
        for (int i = m-2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + cur.get(j);
            }
        }
        return dp[0];
    }
}
