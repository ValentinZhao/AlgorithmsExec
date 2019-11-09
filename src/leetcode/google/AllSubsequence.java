package google;

import java.util.ArrayList;
import java.util.List;

/**
 * "abcabc", "abc" -> [0,1,2], [0,1,5], [0,4,5], [3,4,5]
 *
 * backtracking 秒
 */
public class AllSubsequence {
    public List<List<Integer>> getAll(String s, String t) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(s, t, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(String s, String t, int s_start, int t_start, ArrayList<Integer> temp, List<List<Integer>> res) {
        if (t_start == t.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = s_start; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(t_start)) {
                temp.add(i);
                backtracking(s, t, i + 1, t_start + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
