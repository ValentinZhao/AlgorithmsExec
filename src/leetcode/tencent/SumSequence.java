package tencent;

import java.util.ArrayList;

public class SumSequence {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> sumSeq(int m) {
        backtracking(1, 0, m, new ArrayList<Integer>());
        return res;
    }

    private static void backtracking(int start, int sum, int max, ArrayList<Integer> temp) {
        if (sum > max) return;
        if (sum == max) res.add(new ArrayList<>(temp));
        for (int j = start; j <= max; j++) {
            if (!temp.contains(j)) {
                temp.add(j);
                backtracking(j, sum+j, max, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        sumSeq(6);
    }
}
