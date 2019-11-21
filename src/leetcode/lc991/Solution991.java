package lc991;

public class Solution991 {
    public int brokenCalc(int X, int Y) {
        int ans = 0;

        while (X < Y) {
            ans++;
            if (Y % 2 == 1) Y++; // 奇数直接除2会出现个数偏移，要加到高位
            else Y /= 2;
        }

        return ans + X - Y;
    }
}
