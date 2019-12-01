package com.neu.cs5800.utils;

import com.neu.cs5800.InvertedIndex;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static int countTrie(InvertedIndex.TrieNode root) {
        int res = 0;
        if (root.isWord) {
            res++;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                res += countTrie(root.children[i]);
            }
        }

        return res;
    }
}
