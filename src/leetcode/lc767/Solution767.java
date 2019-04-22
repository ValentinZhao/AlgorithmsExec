package lc767;

/**
 * Count letter appearance and store in hash[i]
 * Find the letter with largest occurence.
 * Put the letter into even index numbe (0, 2, 4 ...) char array
 * Put the rest into the array
 */
public class Solution767 {
    public String reorganizeString(String S) {
        int mostFreqLetterIdx = 0, max = 0;
        int[] hash = new int[26];
        for (char c : S.toCharArray()) {
            hash[c-'a']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                mostFreqLetterIdx = i;
            }
        }
        if (max > (S.length() + 1) / 2) return "";
        char[] seq = new char[S.length()];
        int idx = 0;
        while (hash[mostFreqLetterIdx] > 0) {
            seq[idx] = (char)('a'+mostFreqLetterIdx);
            idx += 2;
            hash[mostFreqLetterIdx]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= seq.length) idx = 1;
                seq[idx] = (char)('a'+i);
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(seq);
    }
}
