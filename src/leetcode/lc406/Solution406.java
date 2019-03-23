package lc406;

import java.util.Arrays;

/**
 * 这道题其实就是两步，第一步把所有的元素按照height从高到低进行排列，同等高度的又按照index的大小升序排列
 * 第二步就是在新的数组中按照顺序插入这些元素，按照自带的index插入到新数组的index的位置即可
 *
 * E.g.
 * input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * sub-array after step 1: [[7,0], [7,1]]
 * sub-array after step 2: [[7,0], [6,1], [7,1]]
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int [][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int pos = people[i][1];
            // 插入逻辑是很巧妙的，首先我们找到要插入的index，然后我们从后往前遍历
            // 然后我们把每个位置的前一个位置的元素复制到当前位置，这样其实就是把整体向后copy了一位
            // 这样其实就把需求的index的位置空出来了
            for (int j = i; j > pos; j--) {
                res[j] = res[j-1];
            }
            res[pos] = people[i];
        }
        return res;
    }
}
