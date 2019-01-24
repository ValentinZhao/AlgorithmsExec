package lc008;

public class Solution008 {
    public int myAtoi(String str) {
        char[] strArr = str.toCharArray();
        int sign = 1, base = 0, i = 0;
        for (int j = 0; j < strArr.length; j++) {
            if (strArr[j] == ' ') continue;
            if (strArr[j] == '-') sign = -sign;
            if (strArr[j] > '0' && strArr[j] < '9') {
                if (base > Integer.MAX_VALUE / 10 || base == Integer.MAX_VALUE / 10 && strArr[j] > '7') {
                    return sign > 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            base = base * 10 + (strArr[j] - '0');
        }
        return base * sign;
    }
}
