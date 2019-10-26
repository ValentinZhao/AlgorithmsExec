package lc1007;

public class Solution1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int[] count = new int[7], countA = new int[7], countB = new int[7];

        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                count[A[i]]++;
            } else {
                count[A[i]]++;
                count[B[i]]++;
                countA[A[i]]++;
                countB[B[i]]++;
            }
        }

        for (int i = 1; i < 7; i++) {
            if (count[i] == n) {
                return Math.min(countA[i], countB[i]);
            }
        }

        return -1;
    }
}
