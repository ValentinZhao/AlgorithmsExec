package lc381;

import java.util.*;

public class Solution381 {
    class RandomizedCollection {
        List<Integer> list;
        /**
         * 某个值，出现过的位置的index集合
         */
        Map<Integer, Set<Integer>> map;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if (!map.containsKey(val)) map.put(val, new LinkedHashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return map.get(val).size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).size() == 0) return false;
            int rmIndx = map.get(val).iterator().next();
            int last = list.get(list.size()-1);
            map.get(val).remove(rmIndx);
            map.get(last).remove(list.size()-1);
            map.get(last).add(rmIndx);
            list.set(rmIndx, last);
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }

}
