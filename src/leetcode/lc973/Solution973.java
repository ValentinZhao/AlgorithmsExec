package lc973;

import java.util.Arrays;

/**
 * 一个非常经典的Kth问题，我们有一个通用的解法就是quick select，基本做法呢就是实现快排的那个partition，然后不断比较返回的pivot点的index和
 * K的大小，如果和K一致，那左边就都是小于K的，这样也就完成了Kth问题
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length, left = 0, right = n-1;
        while (left <= right) {
            int pivot = partition(points, left, right);
            if (pivot < K) left = pivot + 1;
            else if (pivot > K) right = pivot - 1;
            else break;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    /**
     * partition的作用就无需多言了，通过不断在左右两端和pivot值进行比较，并对换，把比pivot值小的数放在pivot左边，vice versa
     * 初始的pivot我们就直接选择数组最左端的数字，也就是nums[left]这样
     */
    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[left];
        while (left < right) {
            while (left < right && euclideanDistanceCompare(points[right], pivot) >= 0) right--;
            // 终于找到一个从右边读比pivot小的，那我们把这个值换到左边去
            points[left] = points[right];
            while (left < right && euclideanDistanceCompare(pivot, points[left]) >= 0) left++;
            // 终于找到一个从左边读比pivot大的，那我们把这个值换到右边去
            points[right] = points[left];
            // 那你可能会问这样直接赋值不就把原来原位的数字覆盖了么？其实没有，以right指针为例
            // 当你停下来的时候那个位置的数字就已经比pivot小了，是个有问题的位置，下面的left指针找到一个比pivot大的正好赋值到right指针那里去
            // 是非常巧妙的
        }
        points[left] = pivot;
        return left;
    }

    private int euclideanDistanceCompare(int[] p1, int[] p2) {
        return p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1];
    }
}
