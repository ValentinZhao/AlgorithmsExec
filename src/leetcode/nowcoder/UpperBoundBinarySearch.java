package nowcoder;

public class UpperBoundBinarySearch {
    public int upper_bound_ (int n, int v, int[] a) {
        int lo = 0, hi = n-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= v) {
              if (mid == 0 || a[mid-1] < v) return mid+1;
              else hi = mid;
            } else lo = mid + 1;
        }

        return lo+1;
    }
}
