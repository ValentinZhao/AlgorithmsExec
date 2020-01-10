package lc1268;

import java.util.ArrayList;
import java.util.List;

public class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        List<List<String>> res = new ArrayList<>();
        String prefix = "";

        for (String product : products) {
            addWord(root, product);
        }

        for (char c : searchWord.toCharArray()) {
            prefix += c;
            List<String> list = searchForPrefix(root, prefix);
            res.add(new ArrayList<>(list));
        }

        return res;
    }

    private List<String> searchForPrefix(TrieNode root, String prefix) {
        int count = 0;
        TrieNode curr = root;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : prefix.toCharArray()) {
            if (curr.children[c-'a'] == null) return new ArrayList<>();
            curr = curr.children[c-'a'];
            sb.append(c);
        }

        traverseTrie(curr, sb, res);

        return res;
    }

    private void traverseTrie(TrieNode curr, StringBuilder sb, List<String> res) {
        if (curr.isWord && res.size() < 3) {
            res.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                sb.append((char)i+97);
                traverseTrie(curr.children[i], sb, res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    private void addWord(TrieNode root, String product) {
        TrieNode curr = root;
        for (char c : product.toCharArray()) {
            if (curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}

// forget about the trie
class Solution {

}
