package lc212;

import java.util.ArrayList;
import java.util.List;

public class Solution212 {
    private int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, res);
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] board, TrieNode t, List<String> res) {
        char c = board[i][j];
        if (c == '#' || t.children[c - 'a'] == null) return;
        t = t.children[c-'a'];
        if (t.word != null) {
            res.add(t.word);
            t.word = null;
        }
        board[i][j] = '#'; // 这样做的话其实就是一个简单的visited数组，我们不用另外开一个visited做这件事了
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
            dfs(newX, newY, board, t, res);
        }
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root; // 作为一个游标来构建Trie，root是作为dummy head用来返回
            for (char c : w.toCharArray()) {
                if (p.children[c-'a'] == null)
                    p.children[c-'a'] = new TrieNode();
                p = p.children[c-'a'];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode () {
            children = new TrieNode[26];
        }
    }
}
