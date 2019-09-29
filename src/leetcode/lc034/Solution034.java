package lc034;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int start = getFirstEqualGreater(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1,-1};
        return new int[]{start, getFirstEqualGreater(nums, target + 1) - 1};
    }

    // 这个方法返回第一个match target的index值，如果target是不存在的话就会返回比他大的那个数的index值
    private int getFirstEqualGreater(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

/**
 * 一般来说，在有重复元素的数组中找某个元素（他本身也有重复）
 * 我们通过二分查找后，找到的是第几个元素是不确定的
 * 所以我们要继续判断如果a[mid] >= target的话，我们把前一段继续搜索（也就是hi = mid）
 * 这样到最后lo == hi的时候，拿到的应该是第一个下标；所以这里和一般二分查找不同的是
 * 我们以前用二分查找，找到合适的mid就直接返回了，但我们这里找到了mid，却还是要取前一半接着找，就一定能找到最小下标
 * 那么找最后一个下标同理
 *
 * 这里提供一个更好的办法，我们通过上述办法先找最小的，然后直接找target+1元素
 * 因为找的是target+1的最小下标，他肯定比target多一位，我们再减一即可，太巧妙了！
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearchToMin(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        return new int[]{start, binarySearchToMin(nums, target + 1) - 1};
    }

    private int binarySearchToMin(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}