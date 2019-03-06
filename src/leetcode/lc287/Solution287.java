package lc287;

/**
 * 在一个数组中寻找duplicate字符，其实可以把问题等同于在链表中寻找环，那么两个相同的数字其实就是找环的入口
 * https://www.cnblogs.com/hiddenfox/p/3408931.html
 * 上面就提到了找entry point的一个非常好的办法，由于"a=c"，我们在第一次从相遇时再次把一个点扔回起始点，再同时移动
 * 一定会在entry point相遇
 * 这题本身比较抽象吧，其实并没有链表，但是由于所有数字都小于数组长度的值，所以我们可以用数组元素本身作为数组下标进行遍历
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0], fast = nums[nums[0]];
            while (slow != fast) {
                // slow查找一次，fast查找两次
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            // 此时找到了，fast归零，同时以相同速度前进就可以在entry point相遇
            fast = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }
}
