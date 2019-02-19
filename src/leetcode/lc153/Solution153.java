package lc153;

/**
 * 切割pivot形成两端sorted数组找最小值，典型二分查找法，some principles
 * 1. 如果nums[0] > nums[nums.length - 1]的话，说明这段数组有序，直接返回nums[0]
 * 2. 如果不是上面的情况，直接二分查找，mid跟首位数字进行比较，如果比它大就取后面那段，vice versa
 */
public class Solution153 {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            // 等号的意义是，当最后只剩两个元素，（0+1）/2=0，其实就是nums[0]和nums[0]比较，不加等号会判断错误
            if (nums[0] <= nums[mid]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }
}
