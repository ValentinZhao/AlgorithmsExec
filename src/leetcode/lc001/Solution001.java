package lc001;

import java.util.HashMap;
import java.util.Map;

/**
 * 不能把nums给排序掉，否则index对不上，而且也无法处理有相同元素的情况，只能用hashmap来存key-value然后到时候直接取就行了
 * 当然，backtracking直接暴力找也行
 */
public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
