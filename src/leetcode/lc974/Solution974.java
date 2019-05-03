package lc974;

/**
 * 整体的理论还是没有完全搞懂
 *
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217980/Java-O(N)-with-HashMap-and-prefix-Sum
 *
 * 关键词：contiguous subarray 前缀和求余
 */
public class Solution974 {
    public int subarraysDivByK(int[] A, int K) {
        // 只记录mod K的结果的数组，那么结果肯定只有0-K这些数
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0) sum += K; // Because -1 % 5 = -1, but we need the positive mod 4
            count += map[sum]; // WHYYY????
            map[sum]++;
        }
        return count;
    }
}
