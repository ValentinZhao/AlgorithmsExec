package lc791;

public class Solution791 {
    public String customSortString(String S, String T) {
        int[] bucket = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : T.toCharArray()) bucket[c-'a']++;
        for (char c : S.toCharArray()) {
            // 同一个字符可能出现多次，所以要这样
            for (int i = 0; i < bucket[c - 'a']; i++) {
                sb.append(c);
            }
            bucket[c-'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
