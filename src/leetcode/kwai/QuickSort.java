package kwai;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,9,23,12,66,50};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len-1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot-1);
            quickSort(arr, pivot+1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        while (lo < hi) {
            while (lo < hi && arr[hi] >= pivot) hi--;
            if (lo < hi) {
                swap(arr, lo, hi);
                lo++;
            }
            while (lo < hi && arr[lo] <= pivot) lo++;
            if (lo < hi) {
                swap(arr, lo, hi);
                hi--;
            }
        }

        return lo;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
