package lc126;

import java.util.*;

public class Solution126 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // hash set for both ends
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        // initial words in both ends
        set1.add(start);
        set2.add(end);

        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // build the map
        // 由80和87行就知道，map只有在dict里面的单词被发现时才会put给一个属于它的list
        // 这样我们就知道最后map中保存的就是，所有dict中的词和它下一步可以变换的词，当然可变换的词也是在dict内的
        helper(dict, set1, set2, map, false);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Arrays.asList(start));

        // recursively build the final result
        generateList(start, end, map, sol, res);

        return res;
    }

    boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) {
            return false;
        }

        // 选较长的是因为一会儿我们要根据start set也就是set1来进行遍历
        if (set1.size() > set2.size()) {
            return helper(dict, set2, set1, map, !flip);
        }

        // remove words on current both ends from the dict
        // 已经在首尾set的单词不需要再检查是否能变过去
        // 然后set1和set2的内容是不会发生改变的，也是作为dict来使用
        // 同时这个set也方便我们做差集从dict中去掉某些词
        dict.removeAll(set1);
        dict.removeAll(set2);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        // 找到了在dict里的一个词，塞到set里传到下一层，避免后面递归塞同样的单词
        Set<String> set = new HashSet<String>();

        // for each string in end 1
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // change one character for every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;

                    String word = new String(chars);

                    // make sure we construct the tree in the correct direction
                    // 所以一般来说key是变过的单词，value是起始的单词
                    String key = flip ? word : str;
                    String val = flip ? str : word;

                    // 这个list其实就是一个像是回溯法的tempList，用来在调用栈中维护答案list
                    // 一个单词有一个对应的list维护在map中，那么如果该单词原来有list就直接取出来了
                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

                    if (set2.contains(word)) {
                        done = true;

                        list.add(val);
                        map.put(key, list);
                    }

                    if (!done && dict.contains(word)) {
                        set.add(word);

                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }

        // early terminate if done is true
        return done || helper(dict, set2, set, map, !flip);
    }

    void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (start.equals(end)) {
            res.add(new ArrayList<String>(sol));
            return;
        }

        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
            return;
        }

        for (String word : map.get(start)) {
            sol.add(word);
            generateList(word, end, map, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}
