package lc041;

/**
 * 不依赖任何数据结构，在O(n)内找到一串Integer中最小的负数，解题思路为
 * 1. 利用swap函数来进行in-array的置换来节省空间，我们的目的是把nums[i]放到i-1的位置
 * 2. 利用while循环不断的给nums[i]尽量放到i-1的位置，比如把1放到index 0处
 * 3. 最后再从头开始遍历即可，找第一个index+1和nums[index]不相等的数
 */
public class Solution041 {
    public int firstMissingPositive(int[] nums) {
        int cursorIndex = 0;
        while (cursorIndex < nums.length) {
            if (    nums[cursorIndex] > 0 &&
                    nums[cursorIndex] <= nums.length &&
                    nums[nums[cursorIndex] - 1] != nums[cursorIndex]) {
                swap(nums, cursorIndex, nums[cursorIndex] - 1);
            } else cursorIndex++;
        }
        for (cursorIndex = 0; cursorIndex < nums.length; cursorIndex++) {
            if (nums[cursorIndex] != cursorIndex + 1) break;
        }
        return cursorIndex + 1;
    }

    private void swap(int[] nums, int cursorIndex, int i) {
        int temp = nums[cursorIndex];
        nums[cursorIndex] = nums[i];
        nums[i] = temp;
    }
}
