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
                    word = word.toLowerCase();
                    indices.putIfAbsent(word, new HashMap<>());
                    indices.get(word)
                           .put(documentId,
                                   indices.get(word)
                                          .getOrDefault(documentId, 0) + 1
                    );
                }

                // iterate all words again to put inverted list at the leaf
                for (String word : words) {
                    addWord(word, root, documentId);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        ws.invertedList.add(Arrays.asList(documentId, indices.get(word).get(documentId)));
        ws.isWord = true;
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        // invertedList -> [[id1, occurrence1], [id2, occurrence2], ...]
        List<List<Integer>> invertedList;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            invertedList = new ArrayList<>();
        }
    }
}
