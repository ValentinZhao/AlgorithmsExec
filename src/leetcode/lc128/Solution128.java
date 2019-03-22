package lc128;

import java.util.HashMap;
import java.util.Map;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.containsKey(num-1) ? map.get(num-1) : 0;
                int right = map.containsKey(num+1) ? map.get(num+1) : 0;
                int sum = left + right + 1;
                map.put(num, sum);
                max = Math.max(max, sum);
                // 最巧妙的就是这里，上面的left和right表示当前数字的左右两个数字所在的的consecutive sequence最长是多少
                // 因为都是连续递增的序列，所以我们直接用当前数字减去这个值，就能得到这个序列中的边界元素值，把这个边界元素更新到最新的sum
                // 这样下次他们被使用的时候就会返回新的longest consecutive sequence长度
                // 赋予相同的sum值就是因为这些数字全部都出现在同一个sequence里面
                map.put(num-left, sum);
                map.put(num+right, sum);
            } else {
                continue;
            }
        }
        return max;
    }
}
