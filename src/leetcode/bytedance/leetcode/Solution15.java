package bytedance.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // 只迭代到length-2，因为后面只少要留两个元素
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length-1, sum = 0 - nums[i];
            if (i == 0 || nums[i] != nums[i-1]) { // 跳过相等的元素
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        // 跳过相等的元素
                        while (start < end && nums[start] == nums[start+1]) start++;
                        while (start < end && nums[end] == nums[end-1]) end--;
                        start++;end--;
                    } else if (nums[start] + nums[end] > sum) end--;
                    else start++;
                }
            }
        }

        return res;
    }
}
