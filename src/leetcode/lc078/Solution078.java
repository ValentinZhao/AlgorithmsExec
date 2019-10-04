package lc078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        System.out.println(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            // 每次backtracking都是传入i+1，意思就是递归探查出多一个tempList元素下的所有情况，每次递归就加一个元素
            // 意思就是，越深层级的backtracking拥有越多tempList的元素，并且在退出该层递归之前，进行一次remove，把推入的元素推出
            // 这样就可以保证回到上一层时，元素少一个，回到最高层就只有一个元素这样子
            // 这个backtracking的特点在于，外层循环不断推进，使得传入的start一直向前而不用重新检查前面的元素
            // 所以也不用判断是否tempList中的duplicate情况

             // 简单来说就是，每传进去一层，tempList前面的前缀部分不会变，比如整串[1,2,3]，我tempList中有一个1
            // 然后进入下一层，一开始是被推入2，变为了[1,2]，这时候再次进入就推入了3变为[1,2,3]，退出之后再退出只剩[1]
            // 这时候循环向后走，推入3，这时候我们得到[1,3]。所以[1]是一直不变的。同理在下一层也会有固定的[1,2]，[1,3]前缀等（视具体情况而变）
            // 就这样我们完成了所有subset的遍历
            backtracking(list, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
