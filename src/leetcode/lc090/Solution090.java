package lc090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            backtracking(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1); // 前面回溯完之后我们要把22行加入的元素推出，下一轮循环将插入新元素，然后再进行回溯
        }
    }

}