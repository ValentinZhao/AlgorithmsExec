package lc819;

import java.util.*;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] para = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String word : para) {
            if (!set.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        String maxStr = "";
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxStr = entry.getKey();
            }
        }
        return maxStr;
    }
}
