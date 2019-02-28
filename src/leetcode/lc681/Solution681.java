package lc681;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 这题的条件其实挺奇葩的，容易审不好题跑偏了，是要你从已有的几个数字中挑出来下一个最近时间
 * 那这样的话其实就从右到左依次考虑就好，想好时间的每一位的限制
 *
 * Treeset是一个基于红黑树的数据结构，不允许null作为元素，并且元素都是排好序的
 */
public class Solution681 {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        Character[] digits = new Character[]{res[0], res[1], res[3], res[4]};
        TreeSet<Character> set = new TreeSet<>(Arrays.asList(digits));
        res[4] = nextDigit(set, res[4], '9');
        if (res[4] > time.charAt(4)) return new String(res);
        res[3] = nextDigit(set, res[3], '5');
        if (res[3] > time.charAt(3)) return new String(res);
        res[1] = nextDigit(set, res[1], res[0] == '2' ? '3' : '9');
        if (res[1] > time.charAt(1)) return new String(res);
        res[0] = nextDigit(set, res[0], '2');
        return new String(res);
    }

    private char nextDigit(TreeSet<Character> set, char c, char upperLimit) {
        // 因为重组后的时间的每一位也必须是原本时间中的字符，所以我们只能这样取
        Character next = set.higher(c);
        // 那么如果set中没有比c更大，或者该数超过限制，那就势必要找一个最小的数，意味着"进位"了
        return next == null || next > upperLimit ? set.first() : next;
    }
}
