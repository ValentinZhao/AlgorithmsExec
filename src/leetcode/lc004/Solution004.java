package lc004;

/**
 * 这题主要难在，强行要求使用二分查找，那就不能通过构造新数组找中点了。我们要找到一个K，使得m1+m2=k，k是两个数组长度和的一半
 * 主要就是找m1和m2，它们代表在两个数组中各取多少个元素。我们把长的数组放在m2上。那么我们对于m1和m2来讲的要求就是A[m1-1]和B[m2-1]
 * 最好是相等的，这样是最完美的m1+m2，具体判断逻辑在代码中，我们还要考虑各种边界条件，主要就是这个中位数可能完全是从第一个或第二个数组中计算得到的
 */

/**
 * 25ms
 */
public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int k = (n1 + n2 + 1) / 2;
        int lo = 0;
        int hi = n1;
        while (lo < hi) {
            int m1 = lo + (hi - lo) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) lo = m1 + 1; // m1还不够多，以至于还没赶上m2的值，那推进一位
            else hi = m1; // m1太多了，把中点变为上限这样找，二分查找嘛
        }
        // 这样找完，就算是m1和m2取完之后中位数并不相等，也是很接近的了
        int m1 = lo;
        int m2 = k - m1;

        // 左中位数
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                          m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1) return c1;
        // 右中位数
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                          m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
    }
}

/**
 * 2ms
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if (x > y) return findMedianSortedArrays(nums2, nums1);
        int k = (x + y + 1) / 2;
        int lo = 0, hi = x;
        while (lo <= hi) {
            int partitionX = lo + (hi - lo) / 2;
            int partitionY = k - partitionX;
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            // find the correct number
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    // anyway, you have to return the biggest number in the left partition
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // partition is way too right, move towards left
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}