package alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 小明在学旋律，每段旋律都可以用字符串来表示，并且旋律的每个
 * 字符的ASCALL码递增的
 * 比如以下4段旋律 :
 * aaa
 * bcd
 * bcdef
 * zzz
 * 现在就是要求，小明能够吧这些旋律拼接起来组成最长的旋律。
 * 比如上述例子输出 11 最长的旋律为 aaabcdefzzz
 */
public class LongestRhythm {
    /**
     * 动态保存全部最大值
     */
    private static int maxLength = 0;
    /**
     * 后缀和，减枝的时候用到
     */
    private static int[] lengthLeft;

    public static void main(String[] args) {
        List<String> melodies = new ArrayList<>(Arrays.asList("aaa", "bcd", "bcdef", "zzz"));
        int res = solve(melodies);
        System.out.println(res);
    }

    public static int solve (List<String> melodies) {
        lengthLeft = new int[melodies.size() + 1];
        // 进行排序, 时间复杂度O(nlog(n))
        melodies.sort(String::compareTo);
        for (int i = melodies.size() - 1; i >= 0; i--) {
            lengthLeft[i] = melodies.get(i).length() + lengthLeft[i + 1];
        }
        nextMelody(melodies,0, 0);
        return maxLength;
    }

    private static void nextMelody(List<String> melodies, int n, int curLength) {
        if (n == melodies.size()) {
            return;
        }
        String curMelody = melodies.get(n);
        curLength += curMelody.length();
        maxLength = Math.max(maxLength, curLength);
        char curMelodyLastChar = curMelody.charAt(curMelody.length() - 1);
        for (int i = n + 1; i < melodies.size(); i++) {
            char nextMelodyFirstChar = melodies.get(i).charAt(0);
            int cmp = curMelodyLastChar - nextMelodyFirstChar;
            // 这个地方就是做一次剪枝，后缀和的意义是当我们访问到某个index时候，看我们还能把这个串加到多长
            // 也就是遍历到i的时候，我们还剩多少可以加。那如果后面剩的长度全部加上来还不足以大于maxLength，就没必要再算了
            // 但是长度其实并不一定是curLength + lengthLeft[i]
            if (cmp <= 0 && curLength + lengthLeft[i] > maxLength) {
                nextMelody(melodies, i, curLength);
            }
        }
    }
}