package lc524;

import java.util.Collections;
import java.util.List;

public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        char[] chs = s.toCharArray();
        String res = "";
        int minCount = Integer.MAX_VALUE;

        for (String word : d) {
            int lo = 0, hi = 0;
            int count = 0;
            int wdIdx = 0;
            char[] ws = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[hi] == ws[wdIdx]) {
                    count += hi-lo;
                    lo = ++hi;
                    wdIdx++;
                    if (wdIdx == ws.length) {
                        if (hi <= chs.length) count += chs.length - hi;
                        break;
                    }
                } else hi++;
            }
            if (wdIdx != ws.length) count = Integer.MAX_VALUE;

            if (minCount > count) {
                minCount = count;
                res = word;
            }
        }

        return res;
    }
}
