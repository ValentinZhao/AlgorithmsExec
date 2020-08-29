package jianzhi;

public class Jz49 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chs = str.toCharArray();
        int sign = 0, res = 0;
        if (chs[0] == '+' || chs[0] == '-') sign = 1;
        for (int i = sign; i < chs.length; i++) {
            if (chs[i] == '+') continue;
//            if (chs[i] < 48 || chs[i] > 57) return 0;
            if (!Character.isDigit(chs[i])) return 0;
            res = 10 * res + chs[i] - 48;
        }

        return (sign == 1 && chs[0] == '-') ? -res : res;
    }
}
