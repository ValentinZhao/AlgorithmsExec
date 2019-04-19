package lc890;

import java.util.ArrayList;
import java.util.List;

/**
 * 所以讨论区想出了一种非常好的匹配pattern的算法，就是按照当前string和pattern的每一位
 * 计算他们与'a'的距离并给到一个26长度的数组内，相当于一个map吧，那么由于pattern一般都是有重复的
 * 只要string和pattern在某一位判断到与'a'的距离出现了区别，那就是不匹配的，都跑完都匹配那就可以
 *
 * 当然还有种情况是pattern本身没有出现过"叠词"现象，那么其实string是什么都无所谓了只要string也不叠词的话
 */
public class Solution890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String w : words) {
            boolean same = true;
            int[] s = new int[26], p = new int[26];
            for (int i = 0; i < w.length(); i++) {
                int strOffset = w.charAt(i)-'a';
                int patrOffset = pattern.charAt(i)-'a';
                if (s[strOffset] != p[patrOffset]) {
                    same = false;
                    break;
                } else {
                    // 使用i+1是因为每个offset其实都需要一个独立的标记，那么第一位由于是0，会分不开是否被计算过，因为新开数组默认也是0
                    s[strOffset] = p[patrOffset] = i + 1;
                }
            }
            if (same) list.add(w);
        }
        return list;
    }
}
