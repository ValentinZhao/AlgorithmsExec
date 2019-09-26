package lc953;

class Solutiono953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        // build the dictionary
        char[] dict = order.toCharArray();
        for (int i = 0; i < dict.length; i++) {
            index[dict[i]-'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            char[] s1 = words[i].toCharArray();
            char[] s2 = words[i+1].toCharArray();

            int len = Math.min(s1.length, s2.length);
            for (int j = 0; j < len; j++) {
                if (s1[j] != s2[j]) {
                    if (index[s1[j]-'a'] > index[s2[j]-'a']) return false;
                    // 这种情况是，找到了一个正确的顺序，就是在这一位上，前面的单词这一位的字典序小于后个单词的，已经成序
                    else len = -1;
                }
            }
            // 还有一种情况是长的词完全覆盖短的词，这时候我们要判断一下长的词是不是在后面
            // 如果在前面也是不行的
            if (len != -1 && s1.length > s2.length) return false;
        }
        return true;
    }
}
