package lc727;

public class Solution727 {
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0) return "";

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";

        while (right < S.length()) {
            int tIdx = 0;

            // 先向右找能够包含所有T的leftmost的位置
            while (right < S.length()) {
                if (S.charAt(right) == T.charAt(tIdx)) tIdx++;
                if (tIdx == T.length()) break;
                right++;
            }
            if (right == S.length()) break; // S遍历到最后了也没找全

            // 再向左找T第一位的字符，这样就能组成一个窗了
            left = right;
            tIdx = T.length() - 1;
            while (left >= 0) {
                if (S.charAt(left) == T.charAt(tIdx)) tIdx--;
                if (tIdx < 0) break;
                left--;
            }

            // 更新最小值
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                res = S.substring(left, right+1);
            }

            right = left + 1; // 最后肯定是右界返回到left+1的位置重新开始，毕竟中间有可能跳过了其他的可能性
        }

        return res;
    }
}
