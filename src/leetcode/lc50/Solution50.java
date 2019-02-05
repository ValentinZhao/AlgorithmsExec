package lc50;

/**
 * 这题解题思路就是利用递归，把乘好的结果逐层往下传，最后**一定会**传到n=1，那么由于n=1
 * 的时候，返回的就是这个当前的x（毕竟下一层就是n=0，返回1），我们就得到了任意阶的幂
 * 注意处理Integer.MIN_VALUE，把它变为Integer.MAX_VALUE - 1即可
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (n == 1) return 1;
        if (n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE - 1;
            x = 1 / x;
        } else if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        // n = 1的时候非常重要，他把之前传下来的x*x全部保存，并乘上myPow(x*x,0),其实就是1，也就是在n=1的时候返回了所有结果
        // 同时我们也知道任何数的1次幂就是他本身
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}