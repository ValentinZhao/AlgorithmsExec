package jianzhi;

public class Jz37 {
    public int GetNumberOfK(int [] array , int k) {
        int lo = 0, hi = array.length-1;
        int left = 0, right = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] >= k) hi = mid - 1;
            else lo = mid + 1;
        }
        left = lo;
        lo = 0;
        hi = array.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] > k) hi = mid - 1;
            else lo = mid + 1;
        }
        right = lo;
        return right - left;
    }
}
