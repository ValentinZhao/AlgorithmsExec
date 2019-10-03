package RandomizedSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> loc_map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        loc_map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (loc_map.containsKey(val)) return false;
        loc_map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!loc_map.containsKey(val)) return false;
        int locOfTarget= loc_map.get(val);
        // 把最后一位的值，复制到target的location上，然后把最后一位remove掉
        if (locOfTarget < nums.size() - 1) {
            int lastElement = nums.get(nums.size() - 1);
            loc_map.put(lastElement, locOfTarget);
            nums.set(locOfTarget, lastElement);
        }
        loc_map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return nums.get(rand.nextInt(nums.size()));
    }
}

class Solution {
    class RandomizedSet {
        private Map<Integer, Integer> idxMap;
        private List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            idxMap = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (idxMap.containsKey(val)) return false;
            idxMap.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!idxMap.containsKey(val)) return false;
            int tgtIdx = idxMap.get(val);
            if (tgtIdx < list.size() - 1) {
                int lastEle = list.get(list.size() - 1);
                idxMap.put(tgtIdx, lastEle);
                list.set(tgtIdx, lastEle);
            }
            idxMap.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random rd = new Random();
            return list.get(rd.nextInt(list.size()));
        }
    }
}