package nutanix;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
 *
 * 就是一个序列是参差不齐的，问你最少去掉几个数字可以让这个序列有一个先增后降的排列，或者全升全降
 * 那么做法就是维护最长非递减序列和最长非递增序列的两个dp数组，再看在哪一位可以让这两个序列的和达到最大
 * 再用总长度减掉即可
 */
public class PerfectRow {
    // 那么我们建立两个dp数组
    // lis[i] 代表以i为**结尾**的最长非递减子序列的长度
    // lds[i] 代表以i为**起始**的最长非递增子序列的长度

    public int Lbs(int[] arr, int n) {
        int i, j;

        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (i = n-2; i >= 0; i--) {
            for (j = n-1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = lis[0] + lds[0] - 1;
        for (i = 0; i < n; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1);
        }

        return n - max;
    }
}