package lc040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;
                temp.add(candidates[i]);
                backtracking(res, temp, candidates, target-candidates[i], i + 1); // 本身不能够进入叠加，所以只能往后走一位
                temp.remove(temp.size()-1);
            }
        }
    }
}
