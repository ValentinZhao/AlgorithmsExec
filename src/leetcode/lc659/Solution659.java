package lc659;

import java.util.HashMap;
import java.util.Map;

public class Solution659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int n : nums) {
            left.put(n, left.getOrDefault(n, 0) + 1);
            end.putIfAbsent(n, 0);
        }

        end.put(0, 0);
        for (int num : nums) {
            if (left.get(num) == 0) continue;
            // 向前读了一位，left对应减一
            left.put(num, left.get(num)-1);
            // 该位前面的数值是存在LIS的，那么LIS就应该加上当前数字而组成一条更长的LIS
            // 所以减前面的，加当前的
            if (end.containsKey(num-1) && end.get(num-1) > 0) {
                end.put(num-1, end.get(num-1)-1);
                end.put(num, end.get(num)+1);
            } else if (left.containsKey(num+1) &&
                       left.get(num+1) > 0 &&
                       left.containsKey(num+2) &&
                       left.get(num+2) > 0) {
                left.put(num+1, left.get(num+1)-1);
                left.put(num+2, left.get(num+2)-1);
                end.put(num+2, end.get(num+2)+1);
            } else return false;
        }
        return true;
    }
}
