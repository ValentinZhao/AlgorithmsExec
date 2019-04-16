package lc080;

/**
 * 这题与lc026的区别在于，我们remove duplicate允许最多存在两个，而不是最多只存在一个
 * 由于一开始事先就是排序好的，我们沿用026的策略，设置一个cursor，从头开始比对前面的元素不一样的就把元素直接给到cursor
 * 同时cursor++，那么这里的话由于可以留两个，所以我们只需要要比对i-2的那个位置上的元素即可
 */
public class Solution080 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums)
            if (index < 2 || nums[index - 2] < num)
                nums[index++] = num;
        return index;
    }
}
