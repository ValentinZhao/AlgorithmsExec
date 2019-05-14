package lc792;

public class Solution792 {
    public int numMatchingSubseq(String S, String[] words) {
        if (words == null || words.length == 0) return 0;
        int sum = 0;
        for (String word : words) {
            if (isSubseq(word, S)) sum++;
        }
        return sum;
    }

    private boolean isSubseq(String word, String S) {
        int index = -1;
        for (char c : word.toCharArray()) {
            index = S.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }
}
