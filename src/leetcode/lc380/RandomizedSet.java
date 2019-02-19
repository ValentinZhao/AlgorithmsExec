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
