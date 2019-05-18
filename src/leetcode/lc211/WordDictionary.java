package lc211;

/**
 * 这题非常好，Trie树的最基本形态和应用的一道题
 */
public class WordDictionary {

    private TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a']; // 这样就形成了自顶向下的一条链
        }
        node.item = word; // 在链表的最后保存了这个word，中间的所有node的item都是空
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chars, int k, TrieNode root) {
        if (k == chars.length) return !root.item.equals("");
        if (chars[k] != '.') { // 是某个确切字符的话，找当前children上有没有这个字母，有这个字母证明前缀吻合，继续向下找
            return root.children[chars[k]-'a'] != null && match(chars, k+1, root.children[chars[k]-'a']);
        } else { // 是字符'.'，那么这个时候就从下一位开始backtracking来找，毕竟当前这位由于是.，可以匹配任意字符
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null) { // 有一个字符在链中才递归
                    if (match(chars, k+1, root.children[i])) { // 向后递归，如果全能匹配了就true
                        return true;
                    }
                }
            }
        }
        return false;
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
}
