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

class Solution {
    public int trap(int[] height) {
        int volume = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else volume += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) rightMax = height[right];
                else volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}

class Solution2 {
    public int trap(int[] height) {
        int volume = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            // 只有左边大于右边当前高度时才动右边，否则左边一直推
            // 实际上是因为右边其实还是取决于左边，具体证明不表
            if (height[left] > height[right]) {
                if (height[left] > leftMax) leftMax = height[left];
                else volume += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) rightMax = height[right];
                else volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}