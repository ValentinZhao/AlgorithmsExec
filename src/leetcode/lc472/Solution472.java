package lc472;


import java.util.ArrayList;
import java.util.List;

public class Solution472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        TrieNode root = new TrieNode();

        for (String w : words) {
            if (w.length() == 0) continue;
            addWord(w, root);
        }

        for (String w : words) {
            if (w.length() == 0) continue;
            if (testWord(w, root, 0, 0)) res.add(w);
        }

        return res;
    }

    /**
     * start就是我们递归开始的位置，我们的查找是这样的，就是首先从上到下的用Trie开始遍历
     * 当找到一个isWord为true的节点我们就知道找到一个单词了，这时候我们从这开始向下递归，把start和count都加一
     * 这个意思就是说我们把一个concat的单词给裂开，有点word break的那种感觉。那么当start到了单词长度时，我们就通过
     * 比较当前count是不是大于1来决定是不是concat词，毕竟concat至少得有两个在dict里的word来拼接
     *
     * count也说了，我们在递归途中，发现了一个isWord我们就加一
     */
    private boolean testWord(String word, TrieNode root, int start, int count) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        int n = word.length();
        // 这个地方直接从start开始查起，非常巧妙了
        for (int i = start; i < n; i++) {
            char c = chs[i];
            if (cur.children[c-'a'] == null) return false;
            if (cur.children[c-'a'].isWord) {
                if (start == n-1) return count > 0;
                // 说一下这里，注意传入的依旧是word和root，意思就是把start和count推进之后
                // 我们从start开始查起（注意本循环i = start）这就完成了一个word break
                // 在前面的符合要求后，我们直接从后面一位重新查起，使用原来的root而不是cur
                if (testWord(word, root, start+1, count+1)) return true;
            }
            cur = cur.children[c-'a'];
        }
        return false;
    }

    private void addWord(String w, TrieNode root) {
        TrieNode cur = root;
        char[] chs = w.toCharArray();
        for (char c : chs) {
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
