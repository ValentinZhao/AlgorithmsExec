package bytedance;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = partition(arr, lo, hi);
            quickSort(arr, lo, mid-1);
            quickSort(arr, mid+1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[0];

        while (lo < hi) {
            while (lo < hi && arr[hi] >= pivot) hi--;
            arr[lo] = arr[hi];
            while (lo < hi && arr[lo] <= pivot) lo++;
            arr[hi] = arr[lo];
        }

        arr[lo] = pivot;

        return lo;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,9,23,12,66,50};
        quickSort(arr, 0, args.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
