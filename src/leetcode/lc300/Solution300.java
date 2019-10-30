package lc300;

/**
 * 我们使用二分查找+DP来以O(NlgN)时间复杂度来解决此题。基本算法就是，先从index=1往后跟dp数组来比
 * 如果这个nums[i]大于这个dp数组的最大值（dp数组就是增长子序列数组，所以最后一位就是最大值）
 * 就把dp[len](这是dp数组新的末尾值，也就是最大值)赋值为nums[i]；如果小于等于dp数组的最大值，那我们就需要在dp数组中通过二分查找
 * 找出这个值所在的位置或者最近位置pos，替换掉比它稍微大一点的那个dp[pos]，以完成更加紧凑的增长序列，最后增长序列的长度就是所需长度，下面是一个例子
 * 10, 9, 2, 5, 3, 7, 101, 18
 *
 * 10
 * 9
 * 2
 * 2,5
 * 2,3
 * 2,3,7
 * 2,3,7,101
 * 2,3,7,18
 * 也就是说，3出现在了5后面，此时增长序列不再增长，而是通过二分查找找到离这个3最近的值，并且用3把它替换掉，这样新序列[2,3]比[2,5]更加紧凑
 * 紧凑的目的在于，如果后面出现了3和5之间的数，比如原序列中是这样的[...2,3,5,4...]那么，这个4其实是需要被插入增长序列的，因为[2,3,4]嘛，但是
 * 如果你不更新这个增长序列，还是[2,5]的话，4就插不进来，因为我们比较插不插入递增序列就是单纯用nums[i]和增长序列最后一位（毕竟是最大值）来比较
 * 所以你得保证递增序列的最大值并不会很大，粒度很小才能保证把后面的递增的数完整的保存下来
 */
public class Solution300 {
    public int lengthOfLongestIncreasingSubsequence(int[] nums) {
        int[] increasingSeq = new int[nums.length];
        int len = 0;
        increasingSeq[len++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > increasingSeq[len - 1]) increasingSeq[len++] = nums[i];
            else {
                int pos = findPos2ReplaceByBinarySearch(increasingSeq, len, nums[i]);
                increasingSeq[pos] = nums[i];
            }
        }
        return len;
    }

    private int findPos2ReplaceByBinarySearch(int[] increasingSeq, int len, int num) {
        int mid;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (increasingSeq[mid] == num) return mid;
            else if (increasingSeq[mid] < num) lo = mid + 1;
            else if (increasingSeq[mid] > num) hi = mid - 1;
        }
        return lo;
    }
}

/**
 * 这个方法可以正确的计算LIS的长度，但其实我们得到的并不一直是正确的LIS
 * 比如[1,5,8,108,9]
 *
 * 我们最后会用9替换掉108，虽然长度依然是4，但其实正确的LIS应该是[1,5,8,108]
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int[] arr = new int[nums.length];
        int len = 0;
        arr[len++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr[len-1]) arr[len++] = nums[i];
            else {
                int pos = binarySearch(arr, len, nums[i]);
                arr[pos] = nums[i];
            }
        }
        return len;
    }

    private int binarySearch(int[] arr, int len, int num) {
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == num) return mid;
            else if (arr[mid] < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}
