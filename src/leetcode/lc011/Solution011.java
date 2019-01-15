package lc011;

/**
 * 双指针题，两个指针数组的两端，每次只向内移动两个指针中值比较小的那个，因为很明显，每次向内移动都会将宽度减1
 * 这时候如果移动高度较大的那个势必不能将所有max的情况全部遍历
 */
public class Solution011 {
    public int maxArea(int[] height) {
        int volume = 0;
        if (height == null) return volume;
        int front = 0, rear = height.length - 1;
        while (front != rear) {
            volume = Math.max(volume, Math.min(height[front], height[rear]) * (rear - front));
            if (height[front] > height[rear]) rear--; else front++;
        }
        return volume;
    }
}
