package lc091;

/**
 * 题目中给了A-Z的对应1-26的一个字典，把一串string解析，看能解析成多少组数字，返回解析种类的数量
 * 比如226，可以分成22 6，2 26， 2 2 6，对应BZ,VF,BBF三种，则返回3
 * 这题很明显，要找出这个字符串的所有组合情况，其实只需要知道它的n-1和n-2时的情况
 * 因为这样就会给最后留下最后一个字母或两个字母的情况，也就是最后在先前的情况下再加两种情况就能变成当前长度下字符串的所有情况了，很典型的DP题
 */
public class Solution091 {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] sums = new int[n + 1];
        sums[0] = 1;
        sums[1] = 1; // 前面只有两种情况，然后这两种情况其实正好补到了最后剩余的两个情况中，所以配好这两个值以后，直接把dp数组加在一起就行了，不用再补2个情况
        int sum = 0; // test case "100", 如果条件过不了会把sum赋值为0
        for (int i = 2; i <= n; i++) {
            sum = (s.charAt(i-1) != '0'?sums[i-1]:0)+(s.charAt(i-2) != '0' && (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6' || s.charAt(i-2) < '2')?sums[i-2]:0);
            sums[i] = sum;
        }
        return sums[s.length()];
    }
}
