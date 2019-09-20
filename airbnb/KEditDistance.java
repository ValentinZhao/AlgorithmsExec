// https://github.com/jxr041100/system_design/blob/master/Airbnb:%20K%20Edit%20Distance
/**
The problem with the previous solution is if the given list of the words is like ab, abc, abcd, 
each time we need to repeatedly calculate the edit distance with the target word. 
If we can combine the prefix of all words together, we can save lots of time. 

Thats why we use trie
 */
public class KEditDistance {
    /*
        K Edit Distance
        AirBnB Interview Question
     */
    public class Solution {
        private void search(String curr, String target, int k, TrieNode root,
                            int[] prevDist, List<String> result) {
            if (root.isLeaf) {
                if (prevDist[target.length()] <= k) {
                    result.add(curr);
                } else {
                    return;
                }
            }

            for (int i = 0; i < 26; i++) {
                if (root.children[i] == null) {
                    continue;
                }

                int[] currDist = new int[target.length() + 1];
                currDist[0] = curr.length() + 1;
                for (int j = 1; j < prevDist.length; j++) {
                    if (target.charAt(j - 1) == (char) (i + 'a')) {
                        // 当前遍历字母与target中对应位置字母相同，那么这一位无需edit，那么distance就和prev[i-1]一样
                        currDist[j] = prevDist[j - 1];
                    } else {
                        // 遍历字母不同时，选个较小的操作，再加1，edit了一次嘛
                        currDist[j] = Math.min(Math.min(prevDist[j - 1], prevDist[j]), currDist[j - 1]) + 1;
                    }
                }

                search(curr + (char) (i + 'a'), target, k, root.children[i], currDist, result);
            }
        }

        public List<String> getKEditDistance(String[] words, String target, int k) {
            List<String> res = new ArrayList<>();
            if (words == null || words.length == 0 || target == null ||
                    target.length() == 0 || k < 0) {
                return res;
            }

            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            TrieNode root = trie.root;
            // The edit distance from curr to target
            // 这相当于一个dp数组
            int[] prev = new int[target.length() + 1];
            for (int i = 0; i < prev.length; i++) {
                prev[i] = i;
            }

            search("", target, k, root, prev, res);

            return res;
        }

        class TrieNode {
            TrieNode[] children;
            boolean isLeaf;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        class Trie {
            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            // Add a word into trie
            public void insert(String s) {
                if (s == null || s.length() == 0) {
                    return;
                }

                TrieNode p = root;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (p.children[c - 'a'] == null) {
                        p.children[c - 'a'] = new TrieNode();
                    }

                    // 遍历到字符串末尾了，给到一个标志位
                    if (i == s.length() - 1) {
                        p.children[c - 'a'].isLeaf = true;
                    }

                    // 每往后遍历了一个字母，就向下移动一位
                    p = p.children[c - 'a'];
                }
            }
        }
    }
}