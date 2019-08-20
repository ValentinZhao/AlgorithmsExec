package lc737;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        DisjointSet dsu = new DisjointSet(pairs.size() * 2);
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        // 首先把pairs中的单词，每个词给到一个id，方便使用并查集来维护查找
        for (List<String> pair : pairs) {
            for (String p : pair) if (!map.containsKey(p)) map.put(p, count++);
            // 把这些id在dsu中串联起来
            dsu.union(map.get(pair.get(0)), map.get(pair.get(1)));
        }
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i], w2 = words1[i];
            if (w1.equals(w2)) continue;
            if (!map.containsKey(w1) || !map.containsKey(w2) ||
                    dsu.find(map.get(w1)) != dsu.find(map.get(w2))) return false;
        }
        return true;
    }

    static class DisjointSet {
        private int[] parents;
        private int[] rank;

        public DisjointSet(int n) {
            parents = new int[n];
            // 一开始每个人的id应该是它自己
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            rank = new int[n];
        }

        public int find(int p) {
            if (parents[p] != p) parents[p] = find(parents[p]);
            return parents[p];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) rank[rootX] = rootY;
                else if (rank[rootX] > rank[rootY]) rank[rootY] = rootX;
                else {
                    rank[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }
    }

}
