package bytedance.leetcode;

public class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int leftMax = 0, rightMax = 0, volume = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            if (height[left] <= height[right]) {
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
