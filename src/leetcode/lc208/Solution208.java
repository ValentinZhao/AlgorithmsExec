package lc208;

import TrieNode.TrieNode;

public class Solution208 {
    private TrieNode root;
    public Solution208() {
        root = new TrieNode();
        // Trie树的头是空的
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // 每次都从root开始找，是Trie树的特性，塞入也是从root开始嘛
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c-'a'] == null) {
                ws.children[c-'a'] = new TrieNode(c);
            }
            ws = ws.children[c-'a']; // 向下继续走
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c-'a'] == null) return false;
            ws = ws.children[c-'a'];
        }
        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c-'a'] == null) return false;
            ws = ws.children[c-'a'];
        }
        return true;
    }
}
