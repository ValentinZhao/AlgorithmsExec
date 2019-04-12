package lc228;

import java.util.ArrayList;
import java.util.List;

/**
 * 非常好的two-pointer题
 */
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i+1] - nums[i] == 1) {
                end++;
                i++;
            }
            if (start == end) list.add(String.valueOf(nums[i]));
            else {
                list.add(nums[start] + "->" + nums[end]);
            }
            start = ++end;
        }
        return list;
    }
}
