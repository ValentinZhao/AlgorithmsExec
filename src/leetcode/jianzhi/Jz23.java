package jianzhi;

public class Jz23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        return helper(sequence, 0, sequence.length-1);
    }

    private boolean helper(int[] sequence, int start, int end) {
        if (start >= end) return true; // 这种情况表示子数组已经收缩到一起，在此之前都没有错误的情况，直接true
        int i = start;
        while (i < end) {
            if (sequence[i++] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }
        return helper(sequence, start, i-1) && helper(sequence, i, end-1);
    }
}
