package lc560;

import java.util.HashMap;
import java.util.Map;

/**
 * 基本思路是，我们既然要找sum[i,j]=k的话，我们就需要找到sum[0, i - 1]和sum[0, j]，就能找到sum[i,j]了
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) { // sum - k能在map中找到的话，说明存在着这样的sum1，使得sum-sum1=k成立
                // 毕竟sum相当于sum[0,j]，sum1相当于sum[0,i-1]，那么sum[i,j]就是sum-sum1咯
                // 这时候的结果就是取出来的一段continuous sub-array
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0 ,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}