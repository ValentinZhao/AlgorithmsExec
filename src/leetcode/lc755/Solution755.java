package lc755;

/**
 * 我们只需要按照题目的规则遍历即可，先往左走，再往右走，最后如果说左走右走都掉不下去的话，就回到K的位置
 */
public class Solution755 {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int cur = K;
            while (cur > 0 && heights[cur] >= heights[cur-1]) cur--;
            while (cur < heights.length - 1 && heights[cur] >= heights[cur+1]) cur++;
            while (cur > K && heights[cur] >= heights[cur-1]) cur--;
            heights[cur]++;
        }
        return heights;
    }
}
