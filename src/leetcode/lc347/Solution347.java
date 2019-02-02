package lc347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 遍历一遍，把所有数字和次数记录在map里面，然后用桶排序的思想，把对应频率给到桶的对应位置，最后轮询这个桶排列
 * 从高往低判定
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> map = new ArrayList<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (map[val] == null) bucket[val] = new ArrayList<>();
            map[val].add(key);

        }
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
