package lc031;

/**
 * 返回一个给定数组的最近的字典序的值，所谓字典序就是按照全排列的方式把一个数字从个位到最高位按照最小increase来排列在一起
 * 这里的话就是要返回一个最近的字典序的数值数组，那么我们的算法就是从数组尾部开始往回遍历，找到第一个nums[i] > nums[i - 1]的i的值
 * 这说明，在i之后的的所有值是一个倒序排列的状态（毕竟这之后的值都是nums[i] < nums[i - 1]）那么我们就从这个i开始，找后面的逆序区域中刚好大于nums[i]的值，进行替换
 * 最后再直接把逆序区域整个逆序排列一下就好，方法就是以中间为节点，不断交换两边的数字就好
 * 这个算法非常棒，在交换nums[i]和最小increase的这一步，就因为原来逆序区域是有序的，所以把nums[i]也换到了一个让逆序区域依然有序的位置，所以后来直接reverse即可
 */
class Solution031 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        int index = n - 1;
        while (nums[index] <= nums[index - 1]) {
            if (nums[index] > nums[index - 1]) break;
            index--;
        }
        if (index == 0) {
            reverseSort(nums, 0, n - 1);
            return;
        } else {
            int val = nums[index - 1];
            int j = n - 1;
            while (j >= index) {
                if (nums[j] > val) break;
                j--;
            }
            swap(nums,j,index-1);
            reverseSort(nums,index,n-1);
            return;
        }
    }

    public void reverseSort(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = 0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
