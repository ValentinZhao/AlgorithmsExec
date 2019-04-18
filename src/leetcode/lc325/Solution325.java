package lc325;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路同2Sum，我们从前往后遍历，并把每个sum[0,i]都记录到hashmap里面，用sum做键，i做value
 * 同时每次迭代我们都检查一下sum-k存不存在，如果存在过，假设此时index为j，那么sum[i,j]就是一个和为k的序列，我们更新subarray的长度
 * 为什么sum-k存在就可以了？因为到j的这个sum是要比k大的，然后sum-k对应的应该是个负数值，那么这时候就可以成立
 */
public class Solution325 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) maxLen = i + 1;
            else if (map.containsKey(sum-k)) maxLen = Math.max(maxLen, i - map.get(sum-k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return maxLen;
    }
}
