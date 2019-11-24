package lc1099;

import java.util.Arrays;

public class Solution1099 {
    public int twoSumLessThanK(int[] A, int K) {
        int low=0, high=A.length-1, maxSum=-1;
        Arrays.sort(A);
        while(low<high) {
            int sum = A[low] + A[high];
            if(sum < K) {
                maxSum = Math.max(sum, maxSum);
                low++;
            } else {
                high--;
            }
        }
        return maxSum;

//        int cur = 0, max = Integer.MIN_VALUE;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < i; j++) {
//                cur = A[i] + A[j];
//                if (cur <= K) max = Math.max(max, cur);
//            }
//        }

//        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
