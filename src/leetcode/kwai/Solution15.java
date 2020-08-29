package kwai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int start = i + 1, end = nums.length-1, sum = target - nums[0];
            if (i == 0 || i > 0 && nums[i] == nums[i-1]) {
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        res.add(Arrays.asList(i, start, end));
                        while (start < end && nums[start] == nums[start+1]) start++;
                        while (start < end && nums[end] == nums[end-1]) end--;
                        start++;end--;
                    } else if (nums[start] + nums[end] > target) end--;
                    else start++;
                }
            }
        }

        return res;
    }
}
