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

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,9,23,12,66,50};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
