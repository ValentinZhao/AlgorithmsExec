package lc809;

public class Solution809 {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            if (check(S, word)) res++;
        }
        return res;
    }

    private boolean check(String s, String word) {
        int j = 0, n = s.length(), m = word.length();
        char[] chs = s.toCharArray();
        char[] whs = word.toCharArray();
        for (int i = 0; i < n; i++) {
            // 不做j < m的限制，那j最后由于在s中重复多次增加了很多，一定会超过word的长度
            if (j < m && chs[i] == whs[j]) j++;
            // 下面两个限制都是说，如果两个字符不同的时候，需要s中至少出现3次这个字符才可能让word中extend到，如果只出现两次那是不可能extend的
            else if (i > 1 && chs[i-2] == chs[i-1] && chs[i-1] == chs[i]);
            else if (0 < i && i < n-1 && chs[i-1] == chs[i] && chs[i] == chs[i+1]);
            else return false;
        }

        return j == m;
    }
}
