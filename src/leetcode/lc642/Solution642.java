package lc642;

import java.util.*;

public class Solution642 {
    class AutocompleteSystem {

        private TrieNode root;
        private String prefix;

        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            prefix = "";

            for (int i = 0; i < sentences.length; i++) {
                addNode(sentences[i], times[i]);
            }
        }

        private void addNode(String s, int times) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                TrieNode next = curr.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    curr.children.put(c, next);
                }
                curr = next;
                curr.count.put(s, curr.count.getOrDefault(s, 0) + times);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                // 此时的prefix其实是输入完的一段字符串，当前是#所以结束输入
                // 同时重置prefix
                addNode(prefix, 1);
                prefix = "";
                return new ArrayList<>();
            }

            prefix += c;

            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                TrieNode next = curr.children.get(ch);
                if (next == null) return new ArrayList<>();
                curr = next;
            }

            // 建立大顶堆，次数较高的在上面，否则字典序较小的在前面
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) ->
                    a.getValue().equals(b.getValue()) ?
                            a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
            );
            pq.addAll(curr.count.entrySet());
            List<String> res = new ArrayList<>();
            int K = 3;
            while (!pq.isEmpty() && K > 0) {
                res.add(pq.poll().getKey());
                K--;
            }
            return res;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        /**
         * 这个count的意思是，这里面存的String是当前add的字符串的出现次数
         */
        Map<String, Integer> count;

        public TrieNode() {
            children = new HashMap<>();
            count = new HashMap<>();
        }
    }

}
