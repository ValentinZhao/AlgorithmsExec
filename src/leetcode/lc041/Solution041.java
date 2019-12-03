package lc041;

import java.util.Arrays;

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

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //该数组用于记录原数组信息，下标记录原数组的值
        int[] tmp = new int[n+2];

        // 只记出现过的，并且范围也在数组大小之内的
        for(int i=0; i<n; i++){
            if(nums[i] > 0 && nums[i] < n+2){
                tmp[nums[i]] = 1;
            }
        }

        // 找第一个没出现过的正整数位置
        for(int i=1; i<n+2; i++)
            if(tmp[i] != 1)
                return i;

        return 1;
    }
}

// O(1) space
class Solution1 {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        System.out.println(Arrays.toString(A));
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}