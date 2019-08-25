package lc140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这题的基本思想就是，直接从头开始遍历，找到第一个位置，使得从这个位置开始到最后的一个字母所组成的词是存在于字典中的。
 * 这样我们就可以通过递归前面的部分，来获得一个集合，如果前面的词也能正确形成集合，那我们就把前面词所形成集合和一开始找的后半部分依次组合起来。
 * 所以这道题精髓在于我们是通过找**后半部分**是否存在于字典来进行DFS，我一开始的想法是通过前半部分找
 */
public class Solution140 {
    private static Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        if (map.containsKey(s)) return map.get(s);
        if (wordDict.contains(s)) res.add(s);
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i); // 这个t是后半部分
            if (wordDict.contains(t)) {
                List<String> tempList = wordBreak(s.substring(0, i), wordDict);
                for (String temp : tempList) res.add(temp + " " + t);
            }
        }
        map.put(s, res);
        return res;
    }
}
