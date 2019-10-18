public class Solution {
    public int[] checkPrefix(String[] prefix, String[] numbers) {
        TrieNode root = new TrieNode();

        for (String p : prefix) addNumbers(p, root);

    }

    private int addNumbers(prefix, root) {
        TrieNode ws = root;
        for (char c : p.toCharArray()) {
            if (ws.children[c-'a'] == null) ws.children[c-'a'] = new TrieNode();
            ws = ws.children[c-'a'];
        }
        ws.isWord = true;
    }

    private int search(word) {
        TrieNode ws = root;
        String res = "";
        for (char c : word) {
            if (ws.children[c-'a'] == null) {
                return ws.isWord ? res : "";
            } else {
                res += c;
                ws = ws.children[c-'a'];
            }
        }
        return res;
    }
}

class TrieNode {
    int[] children = new int[26];
    int isWord = false;
}
