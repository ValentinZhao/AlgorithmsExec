package lc049;

import java.util.*;

/**
 * 算法就是，拿到每个字符串之后打散成数组然后sort，这样anagram就会变成一样的，再用map保存下来整个key->list的对应关系
 * 最后统一输出返回其可
 */
public class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> store = new HashMap<>();
        for (String str : strs) {
            char[] str_arr = str.toCharArray();
            Arrays.sort(str_arr);
            String keyStr = String.valueOf(str_arr);
            if (!store.containsKey(keyStr)) store.put(keyStr, new ArrayList<String>());
            store.get(keyStr).add(str);
        }
        return new ArrayList<List<String>>(store.values());
    }
}
