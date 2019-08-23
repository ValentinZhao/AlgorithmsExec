package lc022;

import java.util.ArrayList;
import java.util.List;

public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(list, "", 0, 0, n);
        return list;
    }

    private void backtracking(List<String> list, String s, int open, int close, int n) {
        System.out.println(s);
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (open < n) backtracking(list, s + '(', open + 1, close, n);
        if (close < open) backtracking(list, s + ')', open, close + 1, n);
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res, "", 0, 0, n);
        return res;
    }

    private void backtracking(List<String> res, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (left < n) backtracking(res, s + "(", left + 1, right, n);
        if (right < left) backtracking(res, s + ")", left, right + 1, n);
    }
}
