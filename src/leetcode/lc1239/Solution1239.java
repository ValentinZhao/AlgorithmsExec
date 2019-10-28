package lc1239;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1239 {
    int res = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return 0;
        dfs(arr, "", 0);
        return res;
    }

    private void dfs(List<String> arr, String path, int start) {
        if (start == arr.size()) return;

        boolean isUniq = isUniqueChars(path);

        if (!isUniq) return;

        res = Math.max(res, path.length());

        for (int i = start; i < arr.size(); i++) {
            dfs(arr, path+arr.get(i), start+1);
        }
    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
