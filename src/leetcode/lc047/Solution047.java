package lc047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtracking(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 我们在做全排列的时候，在backtracking的过程中肯定要避免把上一轮的那个数字重复利用
            // 所以要记录在布尔数组中，记录下哪一位的数字被用过了，就不要再访问
            // 之前我们就只需要查找temp里面有没有这个数字即可，现在有了duplicate就麻烦一些，我们用布尔数组直接记录每一位数字的访问情况，效果相同
            // 同时也检查前后两个数字是否一致，如果重复了也是直接跳过
            if (visited[i] || !visited[i] && i > 0 && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            backtracking(list, temp, nums, visited);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
