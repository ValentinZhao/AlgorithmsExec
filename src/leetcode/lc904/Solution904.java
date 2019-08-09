package lc904;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem
 * "Start from any index, we can collect at most two types of fruits. What is the maximum amount"
 *
 * Translation
 * Find out the longest length of sub-arrays with at most 2 different numbers?
 */
public class Solution904 {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int head = 0, res = 0;
        // i不断向后遍历，i就代表窗口尾部
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            // 超过两个种类，那么前面的种类就得去掉了，滑动窗口嘛，同时窗口头部向后移动
            while (map.size() > 2) {
                map.put(tree[head], map.get(tree[head]) - 1);
                if (map.get(tree[head]) == 0) map.remove(tree[head]);
                head++;
            }
            // 由于比如说我们退了前面的水果，而后面的水果数量又没前面的多，这是返回的还应该是之前的amount，那么我们这里存下来res并取max即可
            res = Math.max(res, i - head + 1);
        }
        return res;
    }
}

class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int head = 0, res = 0;
        for (int i = 0; i < tree.length; i++) {
            int curr = tree[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while (map.size() > 2) {
                int currHead = tree[head];
                map.put(currHead, map.get(currHead) - 1);
                if (map.get(currHead) == 0) map.remove(currHead);
                head++;
            }
            res = Math.max(res, i - head + 1);
        }
        return res;
    }
}