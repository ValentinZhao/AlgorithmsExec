package lc131;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void backtracking(List<List<String>> list, ArrayList<String> tempList, String s, int start) {
        // 退出条件是这轮回溯读到string的末尾了，就该退回到上一级回溯，上一级回溯就是向前一个字母
        if (start == s.length()) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    // 从下个字母开始进行向后回溯
                    backtracking(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
