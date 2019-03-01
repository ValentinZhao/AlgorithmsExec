package lc096;

/**
 * 本质上是个数学问题，这里有详尽的公式推导过程
 * https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
 * 简而言之就是，比如说我们设置DP数组为以n个数组成的所有的独立BST个数dp[n]，那么我们可以把问题分解为，F(i,n)，以i(1<=i<=n)为树的root的所有BST个数
 * 那么比如说，[1,2,3,4,5]这样的一串数字代表了BST里面的点，我们找F(3,5)的话，其实是把array分成两部分，一部分是[1,2]另一部分[4,5]那其实就是dp[2]+dp[2]
 * 毕竟dp表示的是n个数组成的独立BST个数嘛，那其实分解一下就是F(i,n)=dp[i-1]*dp[n-i]，然后我们又知道dp[n]=F(i,n)-i从0到n的和，合并公式就可以了
 * dp[n] = dp[0]*dp[n-1]+dp[1]*dp[n-2] +...+dp[n-1]*dp[0]
 */
public class Solution096 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
