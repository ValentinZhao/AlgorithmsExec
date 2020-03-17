package alibaba;

import java.util.Arrays;

/**
 * 具体查看：https://segmentfault.com/a/1190000013960582
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,9,23,12,66,50};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {

            // 这里很重要，每一趟建堆，我们都把堆整理的数组部分长度减一
            // 这样是因为，我们后面要把排在数组头部的最大值，和当前的数组尾部（注意，不一定是arr.length-1，因为我们调整的长度其实一直在缩减）
            // 这样就能做到说，我们把最大值扔到最后，倒数第二大扔在倒数第二位。。。以此类推完成排序
            maxHeapify(arr, len-i);

            swap(arr, 0, len-1-i);
        }
    }

    /**
     * 完成一次建堆，最大值在堆的顶部(根节点)
     */
    private static void maxHeapify(int[] arr, int size) {
        // 这个size就很传神，他不一定是原来的arr的长度，只是表示原arr需要调整的长度

        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size-1; i >= 0; i--) {
            heaping(arr, i, size);
        }

    }

    /**
     * 一个节点二叉堆化的过程，所以我叫做heaping
     */
    private static void heaping(int[] arr, int currentIndex, int size) {
        if (currentIndex < size) {
            int max = currentIndex; // 先认为父节点（也就是当前节点）是最大的

            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;

            if (left < size)
                if (arr[max] < arr[left]) max = left;
            if (right < size)
                if (arr[max] < arr[right]) max = right;

            //如果最大的不是根元素位置，那么就交换
            // 这里的交换的意思就是把这个当前节点一直向下交换，直到找到合适的位置
            // 也就是说下面这个判断是false的时候，也就是当前节点是最大的时候，它就不用再向下交换了
            if (max != currentIndex) {
                swap(arr, currentIndex, max);

                heaping(arr, max, size);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
