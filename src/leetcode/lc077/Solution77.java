package lc077;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void backtracking(List<List<Integer>> res, ArrayList<Integer> tempList, int i, int n, int k) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int j = i; j <= n; j++) {
            tempList.add(j);
            backtracking(res, tempList, j+1, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }
}
