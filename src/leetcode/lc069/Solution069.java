package lc069;

/**
 * 利用二分查找，从1到Integer.MAX_VALUE这个范围开始找
 * 算法就是，mid*mid < x && (mid+1) * (mid+1) > x 的话，mid就是我们要的根
 *
 *  NOTE: 不要直接mid*mid > x这样来比，因为当mid是16位的整型时会溢出Integer，所以我们要 mid > x/mid这样来比
 *  同理还有计算mid的时候，不要(lo + hi) / 2这样来计算，因为lo+hi有可能溢出，要lo + (hi-lo) / 2
 */
public class Solution069 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int lo = 1, hi = Integer.MAX_VALUE;
        while (true) {
            int mid = lo + (hi-lo) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                if ((mid+1) > x / (mid+1)) return mid;
                lo = mid + 1;
            }
        }
    }
}
