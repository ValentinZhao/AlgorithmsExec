package lc085;

import java.util.Arrays;
import java.util.Stack;

/**
 * 我们知道形成完整的矩形要求很严苛，我们只能通过loop-loop来找y方向最长的连续1，左边界找最右，右边界找最左才能形成valid rectangle
 * 基本就是一个多指针往里缩的一个算法，处理好细节就能做对。维护三个指针
 * height[i] i代表某一列，这个数组用来储存每列最高的连续'1'的出现次数，其实就是矩形的高
 * left[i] i代表某一列，这个数组用来储存某一列能达到的"最右"的位置
 * right[i] vice versa
 * 所以简而言之就是i都是代表列的index，随着从上往下遍历不断更新这个i是否要归零，比如从上往下这一列一直是1，那height[j]就很高，出现了一次0就整列归零
 * left和right也同理，从上往下遍历的时候会有一个变量记录左右边界的极值，如果元素为1，把极值给到这个left、right，否则就归零（或给到最大，就都是初始化）
 * 这样就能保证维护着一个三指针内的区域都是1了
 */
public class Solution085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, maxArea = 0;;
        int[] height = new int[col];
        int[] left = new int[col];
        int[] right = new int[col];
        Arrays.fill(right, col - 1);
        for (int i = 0; i < row; i++) {
            // 我们先从右边指针开始往回推
            int rB = col - 1; // 右边界，在下面按照列的循环中不断更新，更新值为最左的列数
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], rB);
                else {// 遇到0了，初始化该列的right
                    right[j] = col - 1;
                    rB = j - 1; // 这时候右边界至少得更往左才行，所以直接往回走一位
                }
            }
            int lB = 0;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], lB);
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
            }
        }
        return maxArea;
    }
}

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rLen = matrix.length, cLen = rLen == 0 ? 0 : matrix[0].length, max = 0;
        int[] h = new int[cLen+1];

        for (int row = 0; row < rLen; row++) {
            Stack<Integer> s = new Stack<Integer>();
            s.push(-1);
            for (int i = 0; i <= cLen ;i++) {
                if(i < cLen && matrix[row][i] == '1')
                    h[i] += 1;
                else h[i] = 0;

                // 如果当前高度并非最高，则不断用当前位置去计算最大值，并在最后推入该高度，把高于它的都出栈
                while(s.peek() != -1 && h[i] < h[s.peek()]) {
                    max = Math.max(max, h[s.pop()] * (i - s.peek() - 1));
                }
                s.push(i);
            }
        }
        return max;
    }
}