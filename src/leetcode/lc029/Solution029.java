package lc029;

// 查看一下handbook有除法的整体运算法则

/**
 * 简单再总结下，总而言之就是在divisor
 */
public class Solution029 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1; // 异或，有一个是negative，就是负的

        long dvd = Math.abs(dividend);
        long dvs = Math.abs(divisor);

        int res = 0;
        while (dvs <= dvd) {
            long temp = dvs, mul = 1;
            while (dvd >= temp<<1) {
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            res += mul;
        }
        return sign > 0 ? res : -res;
    }
}
