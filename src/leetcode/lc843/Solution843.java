package lc843;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * 这题简单那来说就是，你有一个wordlist，每个词固定长度为6
 * 你每次使用master.guess()可以得到一个integer，返回你所猜的词，有多少位和target字母相同
 * 你每次都需要在wordlist里面猜
 *
 * 所以很简单，我们实现一个match函数，看当前guess word和wordlist里面所有词，有exactly x个相同位的词
 * 这些词是有可能包含target的，然后我们把这些词给到新list里面，重复即可
 *
 * 着重看一下在list里面随机猜测的算法
 */
public class Solution843 {
    public void findSecretWord(String[] wordlist, Master master) {
        // 最多猜10次，字符最长6位
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordList2 = new ArrayList<>();
            for (String w : wordlist) {
                if (letterMatch(w, guess) == x) wordList2.add(w);
            }
            wordlist = wordList2.toArray(new String[wordList2.size()]);
        }
    }

    private int letterMatch(String s, String v) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == v.charAt(i) ? 1 : 0;
        }
        return count;
    }
}
