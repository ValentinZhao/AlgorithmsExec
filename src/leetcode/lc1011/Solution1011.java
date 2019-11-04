package lc1011;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 0, hi = 0;

        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int curr = 0, days = 1;
            for (int w : weights) {
                // 如果这时候再装就超了，只能下一天再装了
                if (curr + w > mid) {
                    days++;
                    curr = 0;
                }

                curr += w;
            }

            if (days > D) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
