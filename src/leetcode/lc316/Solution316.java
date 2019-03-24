package lc316;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        if (s == "") return s;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        int i = 0;
        int pos = -1;
        boolean[] used = new boolean[26];
        int[] cache = null;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            if (used[s.charAt(i) - 'a']) {
                i++;
                continue;
            }
            if (pos == -1 || s.charAt(i) < s.charAt(pos)) {
                pos = i;
                cache = cnt.clone();
            }
            if (--cnt[s.charAt(i) - 'a'] == 0) {
                i = pos;
                cnt = cache;
                used[s.charAt(i) - 'a'] = true;
                pos = -1;
                builder.append(s.charAt(i));
            }
            i++;
        }
        return builder.toString();
    }
}
