package lc442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解题方法就是，由于数组内的所有元素都是小于等于数组长度的，所以我们找duplicate可以这样，每次用数组内元素值充当数组下标
 * 把访问到的数字都置为负数，这样如果遇到了第二个相同的数会找到同一个位置上去，那个位置的数是负数，我们就知道这个数字是duplicate的啦
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])-1] >= 0) nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            else list.add(Math.abs(nums[i]));
        }
        return list;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) list.add(nums[i]);
            else set.add(nums[i]);
        }
        return list;
    }
}
