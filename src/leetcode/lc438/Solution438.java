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
            if (right - left == p.length() && count[cArr[left++]++] >= 0) counter++;
        }
        return res;
    }
}
