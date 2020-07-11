package lc033;

/**
 * 题解在这个连接上：https://leetcode.windliang.cc/leetCode-33-Search-in-Rotated-Sorted-Array.html
 * 大概意思就是，即使你把原来排序好的数组从某个pivot切开，重新拼成一段，它还是各自有序的
 * 整个算法要求O(logN)的复杂度的话，直接就想到用二分法来做，那就涉及到mid和左右两端的比较的问题，毕竟我们现在的数组不是完全有序的
 * FOR EXAMPLE: 一段原来有序的数组，被切一刀变成[4，5，6，7，0，1，2]
 * 位置： 0 1 2 3 4 5 6
 * 值：   4 5 6 7 0 1 2
 * 下标： 0 1 2 3 4 5 6
 * 也就是现在arr[0]变成了4，arr[1]变成了5，arr[4]变成了1，这种像周期一样突然变小的我们都会考虑到用上取模的操作，这里的规律
 * 0 -> 4, 1 -> 5, 4 -> 1就是加4取7的模，那就抽象成了算法为（位置 + 偏移） % 数组长度，我们要求偏移量
 * 偏移量其实就是值为0处的下标
 * 然后我们发现，当比较mid和start（左侧端点）的时候，无论左侧比mid大还是小，这个最小值都是在mid左侧，那这是不可取的，只能是mid和end来比
 * 然后不断二分就可以了，这样就能找到最小值，获取偏移。
 * 获得偏移值后，我们可以通过上面的公式拿到任意位置的值，再次二分来找我们想要的那个target的位置
 */

/**
 * 非常棒的解法，one-pass，思路也非常清晰
 * 作为此题的标准解法
 */
class Solution3 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1; // 注意这个部分，如果使用 lo <= hi 的二分搜索框架，上界是length-1而不是length！

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;

            if (nums[mid] == target) return mid;
            // 这个判断是说，左边的还是小于中间的，那么也就是说至少lo到mid这段是有序的，那么也就是说mid右边是rotated过的
            else if (nums[lo] <= nums[mid]) {
                // 那么左边既然有序，那么当target是在lo和mid中间的话，我们直接取左边这段，反之取右边
                if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else { // 这里的判断逻辑就都取反即可
                // 这时候其实是比如旋转了很少一部分到前面（那前面的值是很大的），target没有nums[lo]大，这时候target很有可能在后半段
                // 这样的话就要和nums[hi]来比较
                if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return -1;
    }
}

public class Solution033 {
    public int search (int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        //找出最小值的数组下标
   /* while (start < end) {
        int mid = (start + end) / 2;
        if (nums[mid] > nums[end]) {
            start = mid + 1  ;
        } else {
            end = mid;
        }
    }
    int bias = start;*/
        //找出最大值的数组下标
        while (start < end) {
            int mid = Math.round(((float)start + end) / 2);
            if (nums[mid] < nums[start]) {
                end = mid - 1;
            } else {
                start = mid;
            }

        }
        int n = nums.length;
        int bias = (start + n)  - (n - 1); //得到偏移
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;//中间的位置
            int mid_change = (mid + bias) % nums.length;//中间的位置对应的数组下标
            int value = nums[mid_change];//中间位置的值
            if (target == value) {
                return mid_change;
            }
            if (target < value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = Math.round(((float)start + end) / 2);
            if (nums[mid] < nums[start]) end = mid - 1;
            else start = mid;
        }
        int n = nums.length;
        int offset = (start + n) - (n - 1);
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midChange = (mid + offset) % n;
            int value = nums[midChange];
            if (target == value) return midChange;
            else if (target > value) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}