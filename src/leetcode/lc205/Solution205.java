package lc205;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == tt[i]) continue;
            if (map.containsKey(ss[i]) && map.get(ss[i]) != tt[i]) {
                return false;
            }
            if (ss[i] != tt[i]) {
                map.put(ss[i], tt[i]);
            }
        }
        return true;
    }
}
