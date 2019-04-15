package lc216;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> temp, int start, int k, int n) {
        if (n < 0) return;
        else if (temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                backtracking(res, temp, i + 1, k, n - i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
