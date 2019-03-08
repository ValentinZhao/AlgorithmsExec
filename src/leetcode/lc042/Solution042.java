package lc042;

/**
 * two pointers, 方法简单粗暴，从一边往前（回）走，下一个元素比最大值小就用最大值减去这个数，相当于记录一个(maxHeight-curHeight) * 1的体积
 * 左右这样计数过来就好
 */
public class Solution042 {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, volume = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else volume += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}
