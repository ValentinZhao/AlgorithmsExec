package lc829;

/**
 * 既然要把N表示成一个等差数列（公差为1）的和，我们不妨设这个数列的首项是x，项数为m，则这个数列的和就是[x + (x + (m-1))]m / 2 = mx + m(m-1)/2 = N。
 * 接下来，一个很自然的想法就是，枚举m，通过上式判断对于相应的m是否存在合法的x。显然枚举的复杂度是O(sqrt(N))。
 */
public class Solution829 {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int m = 1; ; m++) {
            int mx = N - m * (m-1) / 2;
            if (mx <= 0)
                break;
            if (mx % m == 0)
                ans++;
        }
        return ans;
    }
}
