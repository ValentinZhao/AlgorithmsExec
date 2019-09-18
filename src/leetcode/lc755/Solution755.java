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

    public static class Solution {
        public int[] pourWater(int[] heights, int V, int K) {
            int[] waters = new int[heights.length];
            int[] oriHeights = heights.clone();
            for (int i = 0; i < V; i++) {
                int cur = K;
                while (cur > 0 && heights[cur] >= heights[cur-1]) cur--;
                while (cur < heights.length - 1 && heights[cur] >= heights[cur+1]) cur++;
                while (cur > K && heights[cur] >= heights[cur-1]) cur--;
                waters[cur]++;
                heights[cur]++;
            }
            print(oriHeights, waters);
            return heights;
        }

        private void print(int[] heights, int[] waters) {
            int n = heights.length;

            int maxHeight = 0;
            for (int i = 0; i < n; i++) {
                maxHeight = Math.max(maxHeight, heights[i] + waters[i]);
            }

            for (int height = maxHeight; height >= 0; height--) {
                for (int i = 0; i < n; i++) {
                    if (height <= heights[i]) {
                        System.out.print("+");
                    } else if (height > heights[i] && height <= heights[i] + waters[i]) {
                        System.out.print("W");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

// 更加直观的方法，但不太对
class Solution1 {
    public int[] pourWater(int[] heights, int V, int K) {
        int[] waters = new int[heights.length];
        int pourLocation = K;
        while (V > 0) {
            int left = K - 1;
            while (left >= 0) {
                if (heights[left] + waters[left] > heights[left+1] + waters[left+1]) {

                    break;
                }
                left--;
            }
            if (heights[left+1] + waters[left+1] < heights[K] + waters[K]) {
                pourLocation = left + 1;
                waters[pourLocation]++;
                V--;
                continue;
            }

            int right = K + 1;
            while (right < heights.length) {
                if (heights[right] + waters[right] > heights[right-1] + waters[right-1]) {
                    break;
                }
                right++;
            }
            if (heights[right-1] + waters[right-1] < heights[K] + waters[K]) {
                pourLocation = right - 1;
                waters[pourLocation]++;
                V--;
                continue;
            }

            pourLocation = K;
            waters[pourLocation]++;
            V--;
        }
        int [] res = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            res[i] = heights[i] + waters[i];
        }
        return res;
    }
}