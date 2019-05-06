package lc981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 使用TreeMap来指定value和timestamp
 */
public class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) return "";
        Integer timeStamp = treeMap.floorKey(timestamp);
        if (timeStamp == null) return "";
        return treeMap.get(timeStamp);
    }
}
