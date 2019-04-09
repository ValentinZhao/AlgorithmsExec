package lc248;

public class Solution248 {
    private static char[][] PAIRS = new char[][]{{'0','0'}, {'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public int strobogrammaticInRange(String low, String high) {
        if (low == null || high == null || low.length() > high.length() ||
                (low.length() == high.length()) && low.compareTo(high) > 0) return 0;
        int count = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            // 直接开一个新的char数组进去，长度一开始给好，然后我们之后直接在dfs里面按照两边位置填入char进去
            count += readAllStrobos(low, high, new char[i], 0, i-1);
        }
        return count;
    }

    private int readAllStrobos(String low, String high, char[] chars, int left, int right) {
        if (left > right) {
            String s = new String(chars);
            // 这里就是由于left>right了说明字符串已读完，这时候要比较拼好的chars与low，high的关系
            // 如果长度一致，就比较大小，长度不一致的情况下肯定在range内，因为我们在上层是直接new char[len]的，长度给定了
            if (chars.length == low.length() && s.compareTo(low) < 0 ||
                chars.length == high.length() && s.compareTo(high) > 0) return 0;
            else return 1;
        }
        int count = 0;
        for (char[] pair : PAIRS) {
            chars[left] = pair[0];
            chars[right] = pair[1];
            // don't start with 0
            if (chars.length != 1 && chars[0] == '0') continue;
            // don't put 6/9 at the middle of string. cuz single 6/9 digit is not strobo
            if (left == right && (pair[0] == '6' || pair[0] == '9')) continue;
            count += readAllStrobos(low, high, chars, left+1, right-1);
        }
        return count;
    }
}
