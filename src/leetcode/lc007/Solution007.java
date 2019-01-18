package lc007;

public class Solution007 {
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            if ((sum > Integer.MAX_VALUE || sum == Integer.MAX_VALUE && x % 10 > 7) ||
                    (sum < Integer.MIN_VALUE || sum == Integer.MIN_VALUE && x % 10 > -8)) {
                return 0;
            }
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return sum;
    }
}
