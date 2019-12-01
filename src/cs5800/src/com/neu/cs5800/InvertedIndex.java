package com.neu.cs5800;

import sun.text.normalizer.Trie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InvertedIndex {
    // Map<word, Map<document_id, occurrence>>
    private Map<String, Map<Integer, Integer>> indices;
    private TrieNode root;

    public InvertedIndex () {
        indices = new HashMap<>();
        root = new TrieNode();
    }

    public void buildIndices (String fileName, int documentId) {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(fileName));
            String line = buff.readLine();
            while (line != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.isEmpty()) continue;
                    word = word.toLowerCase();
                    indices.putIfAbsent(word, new HashMap<>());
                    indices.get(word)
                           .put(documentId,
                                   indices.get(word)
                                          .getOrDefault(documentId, 0) + 1
                    );
                }
                line = buff.readLine();

            }

            // iterate all words again to put inverted list at the leaf
            for (String word : indices.keySet()) {
                addWord(word, root, documentId);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TrieNode getRoot() {
        return root;
    }

    private void addWord(String word, TrieNode root, int documentId) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c-'a'] == null) {
                ws.children[c-'a'] = new TrieNode();
            }
            ws = ws.children[c-'a'];
        }
        // invertedList -> [[id1, occurrence1], [id2, occurrence2], ...]
        if (indices.get(word).get(documentId) != null)
            ws.invertedList.add(Arrays.asList(documentId, indices.get(word).get(documentId)));
        ws.isWord = true;
    }
    
    public List<List<Integer>> search (String word) {
        TrieNode ws = getRoot();
        List<List<Integer>> res = null;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (ws.children[chs[i]-'a'] == null) return res;
            else ws = ws.children[chs[i]-'a'];
        }

        return ws.invertedList;
        
    }

    public class TrieNode {
        public boolean isWord;
        public TrieNode[] children;
        // invertedList -> [[id1, occurrence1], [id2, occurrence2], ...]
        public List<List<Integer>> invertedList;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            invertedList = new ArrayList<>();
        }
    }
}
