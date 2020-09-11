package kwai;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(list, "", 0, 0, n);
        return list;
    }

    private void backtracking(List<String> list, String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }

        if (open < n) backtracking(list, s + "(", open + 1, close, n);
        if (close < open) backtracking(list, s + ")", open, close + 1, n);
    }
}
