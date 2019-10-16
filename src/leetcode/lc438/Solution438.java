package lc438;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体这个sliding window模板是在干嘛，请查看LC76!!!!
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
        int left = 0, right = 0, counter = p.length();
        char[] cArr = s.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < p.length(); i++) {
            count[cArr[i]]++;
        }
        while (right < cArr.length){
            if (count[cArr[right++]]-- > 0) {
                counter--;
            }

            if (counter == 0) {
                res.add(left);
            }

            // count[i] >= 0 的i，才是原p中存在的字符位置
            // 向左移动后，count[i]直接加一，因为我们踢走了一个值，后面也许会再遇到，所以要++
            // 如果踢走的是无关字符，那它的count值也不会大于零，没关系；
            // 如果踢走的是相关字符，那它的count值会大于零，后面在第19行再次检查时有可能会再遇到
            if (right - left == p.length() && count[cArr[left++]]++ >= 0) counter++;
        }
        return res;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
        int left = 0, right = 0, counter = p.length(); // counter表示目前还有几个模板内的字符没被匹配到
        int[] count = new int[256];
        for (char c : p.toCharArray()) {
            count[c]++;
        }
        char[] strArr = s.toCharArray();
        while (right < s.length()) {
            // right位置上的字符在count桶中出现过的话，说明是p中的字母，那么我们减少一个counter
            // 那些++,--都出现在变量之后，说明是读取之后才后移right
            if (count[strArr[right++]]-- > 0) counter--;

            if (counter == 0) res.add(left);

            // 当长度达到待匹配长度，这时候就要考虑移动左边的边界
            // 我们会发现，count和left都++了，但是只有它大于等于零（也就是是原来字符串模板内的）才会把counter加上去
            // 但是无论if内执不执行，这些变量都会增加
            if (right - left == p.length() && count[strArr[left++]]++ >= 0) counter++;
        }
        return res;
    }
}

class Solution3 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, counter = p.length();
        int[] count = new int[256];
        char[] chs = s.toCharArray();
        for (char c : chs) count[c]++;

        while (right < s.length()) {
            if (count[chs[right++]]-- > 0) counter--;

            if (counter == 0) res.add(left);

            if (right - left == p.length() && count[chs[left++]]++ >= 0) counter++;
        }
        return res;
    }
}