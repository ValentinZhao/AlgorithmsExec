package lc039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtracking(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtracking(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        } else {
            // 从start开始是很巧妙的，比如一开始是0，那么就会一直递归0，就可以完成说[2,2,2,2] target = 8的combination
            // 然后比如说已经有了[2,3]的搭配，为了避免出现[3,2]的重复，所以我们使得循环开始的i = start，这样就能保证前面前缀不变的情况下只回溯后面的
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtracking(res, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}