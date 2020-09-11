package nowcoder;

public class FindK {
    public int findKth(int[] a, int n, int K) {
        // write code here
        int pivot = 0;
        int lo = 0, hi = n-1;
        while (pivot != n - K) {
            pivot = partition(a, lo, hi);
            if (pivot > n-K) hi = pivot-1;
            else if (pivot < n-K) lo = pivot+1;
        }

        return a[pivot];
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];

        while (lo < hi) {
            while (lo < hi && arr[hi] >= pivot) hi--;
            if (lo < hi) {
                swap(arr, lo, hi);
                lo++; // 从高位换到低位时，低位已经确定比pivot低了，直接向前进不用比较。下面同理
            }
            while (lo < hi && arr[lo] <= pivot) lo++;
            if (lo < hi) {
                swap(arr, lo, hi);
                hi--;
            }
        }

        return lo;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
