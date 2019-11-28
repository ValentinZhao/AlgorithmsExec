package com.neu.cs5800;

import java.util.*;

public class TextSearch {
    public void naiveSearch(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            if (j == m)
                System.out.println("Pattern found at position : " + i);
        }
    }

    public List<Integer> bmhsSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<Integer>();
        int m = text.length();
        int n = pattern.length();
        Map<Character, Integer> rightMostIndexes = preprocessForBadCharacterShift(pattern);
        int alignedAt = 0;
        while (alignedAt + (n - 1) < m) {
            for (int indexInPattern = n - 1; indexInPattern >= 0; indexInPattern--) {
                int indexInText = alignedAt + indexInPattern;
                char x = text.charAt(indexInText);
                char y = pattern.charAt(indexInPattern);
                if (indexInText >= m) break;
                if (x != y) {
                    Integer r = rightMostIndexes.get(x);
                    if (r == null) {
                        alignedAt = indexInText + 1;
                    }
                    else {
                        int shift = indexInText - (alignedAt + r);
                        alignedAt += shift > 0 ? shift : 1;
                    }
                    break;
                }
                else if (indexInPattern == 0) {
                    matches.add(alignedAt);
                    alignedAt++;
                }
            }
        }
        return matches;
    }
    private Map<Character, Integer> preprocessForBadCharacterShift(
            String pattern) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = pattern.length() - 1; i >= 0; i--) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) map.put(c, i);
        }
        return map;
    }

    public void shiftAndSearch(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pat.charAt(i),
                    map.getOrDefault(pat.charAt(i), 0) | (1 << i));
        }
        int d = 0;
        for (int i = 0; i < n; i++) {
            d = ((d << 1) | 1) & (map.getOrDefault(txt.charAt(i), 0));
            if ((d & (1 << (m-1))) != 0)
                System.out.println("Pattern found at position : "+ (i - m + 1));
        }
    }

    public void fakeBMHS (String txt, String ptn) {
        char[] text = txt.toCharArray();
        char[] pattern = ptn.toCharArray();

        int n = text.length;
        int m = pattern.length;

        int[] d = new int[n+1];
        Arrays.fill(d, m);
        for (int i = 0; i < m; i++) {
            d[pattern[i]] = m - i;
        }

        int i = 1;
        while (i <= n - m) {
            int j = 1;
            while (j <= (m ^ (text[i+j-1]=pattern[j])))
                j++;
            if (j > m)
                System.out.println("Pattern found at position : " + i + 1);
            i += d[text[i+m+1]];
        }
    }
}
