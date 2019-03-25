package lc045;

/**
 * 找最少的跳跃步数跳到数组尾部，那么其实就是需要尽量让每一步都跳满自己的pace，然后
 * 我们假设[currentBegin, currentEnd]是当前位置可以移动到的范围，再另外维护一个currentFarthest代表在这个范围内的所有点可以达到的最远值
 * 那么其实我们就知道了，在移动的过程中，如果index遇到了currentEnd，证明跳到了这个区域的终点，需要更新currentEnd到下一个区域（currentBegin自然就是上个状态的currentEnd）
 * 那么此时新的currentEnd就是之前维护的currentFarthest了
 * 其实宏观来看，这就是模拟了一个所有点都取最大跳跃范围然后求步数的一个贪心算法
 */
public class Solution045 {
    public int jump(int[] nums) {
        int jump = 0, currentEnd = 0, currentFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentFarthest = Math.max(currentFarthest, nums[i] + i);
            if (i == currentEnd) {
                currentEnd = currentFarthest;
                jump++;
            }
        }
        return jump;
    }
}
