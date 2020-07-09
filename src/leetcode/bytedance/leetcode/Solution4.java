package bytedance.leetcode;

public class Solution4 {
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
            // 为什么这个判断是找到中点的标志，因为首先left和right数组本身是有序的
            // 其次，当X结点左侧最大值小于Y结点右侧最小值，Y结点左侧最大值小于X节点右侧最小值的时候
            // X，Y结点分割的四部分数组可以完整按顺序组合起来了，因为左侧的部分本来就是较小的，右侧就是较大的
            // 这样我们其实不需要完整的排出来到底的组合数组是怎样的，但我们知道了中间值大概在哪，就这样省下了时间
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
