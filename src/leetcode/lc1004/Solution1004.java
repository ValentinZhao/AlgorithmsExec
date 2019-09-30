package lc1004;

/**
 * Find the longest subarray with at most K zeros.
 *
 * Explanation
 * For each A[j], try to find the longest subarray.
 * If A[i] ~ A[j] has zeros <= K, we continue to increment j.
 * If A[i] ~ A[j] has zeros > K, we increment i.
 */
public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0, right;
        for (right = 0; right < A.length; right++) {
            if (A[right] == 0) K--;
            // 这里K<0，收缩left是因为，如果不收缩，就会有多于K个0，我们填不满，所以要收
            // 当然，收也是尽量收，比如"1100110000"这种情况，K=2，到最后K还是小于0的
            // 但我们也可以都尽量填在最后的0的部分让连续1字符串最长，只是不是最佳填法而已
            if (K < 0 && A[left++] == 0) K++;
        }
        return right - left;
    }
}
