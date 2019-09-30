package lc689;

/**
 * The question asks for three non-overlapping intervals with maximum sum of all 3 intervals.
 * If the middle interval is [i, i+k-1], where k <= i <= n-2k, the left interval has to be in subrange [0, i-1],
 * and the right interval is from subrange [i+k, n-1].
 *
 * So the following solution is based on DP.
 *
 * posLeft[i] is the starting index for the left interval in range [0, i];
 * posRight[i] is the starting index for the right interval in range [i, n-1];
 *
 * Then we test every possible starting index of middle interval, i.e. k <= i <= n-2k,
 * and we can get the corresponding left and right max sum intervals easily from DP. And the run time is O(n).
 */
public class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxSum = 0;
        int[] sum = new int[n+1], ans = new int[3];
        int[] posLeft = new int[n], posRight = new int[n];

        /**
         * 计算每一位之前的元素的和到数组中
         * 毕竟sum[i,j] = sum[j]-sum[i]
         *
         * 这时候，sum[i]的意义为，i之前的所有元素的和，**不包括i**
         */
        for (int i = 0; i < n; i++) sum[i+1] = sum[i] + nums[i];

        /**
         * 计算left指针为起始的，k这么长的range sum最大值
         * 我们从i = k开始遍历，因为我们是用每个window的右边界来遍历的
         * 左边界需要right-k，正好就是0了
         *
         * 下面的计算right指针正好是反之亦然，我们移动的是左边界，右边界就是right+k
         * 为此，我们需要从n-1-k开始向前遍历
         */
        for (int i = k, tot = sum[k]-sum[0]; i < n; i++) {
            // sum整体往前移了一位，所以i+1才是包括nums[i]在内的以前所有数的和
            if (sum[i+1] - sum[i+1-k] > tot) {
                tot = sum[i+1] - sum[i+1-k];
                posLeft[i] = i+1-k;
            } else {
                posLeft[i] = posLeft[i-1];
            }
        }

        for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
            // 注意此处是>=，上面是>，这里就是为了得出字典序最小，需要让window尽量靠左
            if (sum[i+k] - sum[i] >= tot) {
                tot = sum[i+k] - sum[i];
                posRight[i] = i;
            } else {
                posRight[i] = posRight[i+1];
            }
        }
        
        // 最后，扫一遍k <= i <= n-2k，i是中间range的左边界坐标
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i-1], r = posRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if (tot > maxSum) {
                maxSum = tot;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }
}
