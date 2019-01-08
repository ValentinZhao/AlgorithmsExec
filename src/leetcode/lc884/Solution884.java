package lc884;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution884 {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> store = new HashMap<>();
        for (String word : (A + " " + B).split(" ")) {
            store.put(word, store.getOrDefault(word, 0) + 1);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String word : store.keySet()) {
            if (store.get(word) == 1) res.add(word);
        }
        return res.toArray(new String[0]);
    }
}