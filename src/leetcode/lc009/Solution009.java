package lc009;

/**
 * 回文数字题，这个解法非常巧妙，不用检查边界条件，也不需要转化为字符串读charArray
 * 它的算法是，利用rev/10和rev%10来从数字的个位开始，到最后rev/10的这部分最后只能剩前面一半，rev%10的部分从个位开始增长一位，到最后是后面一半
 * 最后再把这两半相比即可
 */
public class Solution009 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x%10 == 0) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (x == rev || x == rev / 10);
    }
}
