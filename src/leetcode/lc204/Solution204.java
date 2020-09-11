package lc204;

/**
 *  埃拉托斯特尼筛法 Sieve of Eratosthenes
 *  质数或者说素数，是指大于1的，除了1和自己不能被整除的
 *  那么遍历小于n的相乘即可，这样可以省下很多时间
 */
public class Solution204 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
