package lc679;

import java.util.ArrayList;
import java.util.List;

/**
 * There are only 4 cards and only 4 operations that can be performed.
 * Even when all operations do not commute, that gives us an upper bound of 12 * 6 * 2 * 4 * 4 * 4 = 9216 12∗6∗2∗4∗4∗4=9216 possibilities,
 * which makes it feasible to just try them all.
 * Specifically, we choose two numbers (with order) in 12 ways and perform one of 4 operations (12 * 4).
 * Then, with 3 remaining numbers, we choose 2 of them and perform one of 4 operations (6 * 4).
 * Finally we have two numbers left and make a final choice of 2 * 4 possibilities.
 * 所以总结起来就是，我们用暴力回溯法总是先算出两个数的结果，然后塞到小数组里面进行递归
 *
 * 关于时间复杂度，由于最多只有9216种情况，所以就算是暴力回溯时间复杂度也是O(1)
 */
public class Solution679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) list.add((double) num);
        return backtracking(list);
    }

    private boolean backtracking(List<Double> list) {
        if (list.size() == 0) return false;
        if (list.size() == 1) return Math.abs(list.get(0) - 24) < 1e-6;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    List<Double> nums = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) if (k != i && k != j) nums.add(list.get(k));
                    for (int k = 0; k < 4; k++) {
                        double num1 = list.get(i), num2 = list.get(j);
                        // 这是个优化，主要是因为加法和乘法在相同的两个元素见结果相同，直接跳过
                        // 这里只计算j < i时的结果
                        if (k < 2 && j > i) continue;
                        if (k == 0) nums.add(num1 + num2);
                        if (k == 1) nums.add(num1 * num2);
                        if (k == 2) nums.add(num1 - num2);
                        if (k == 3) {
                            if (num2 != 0) {
                                nums.add(num1 / num2);
                            } else continue;
                        }
                        if (backtracking(nums)) return true;
                        nums.remove(nums.size()-1);
                    }
                }
            }
        }
        return false;
    }
}
