package lc046;

import java.util.ArrayList;
import java.util.List;

public class Solution046{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtracking(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 给定一个数字返回所有0 - bound-1的permutation
    private void getPermutations(List<List<Integer>> res, int bound, List<Integer> temp) {
        if (temp.size() == bound) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < bound; i++) {
                if (temp.contains(i)) continue;
                temp.add(i);
                getPermutations(res, bound, temp);
                temp.remove(temp.size()-1);
            }

        }
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                backtracking(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}