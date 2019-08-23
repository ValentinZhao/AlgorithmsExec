package lc621;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        // 这里排序的意义在于，我们会把出现次数最多的项排到最后
        // 我们并不需要知道是具体哪个字母出现了几次，毕竟最后需要的只是段数而已，所以我们只需要按照排序后的数组
        // 从后往前，以个数最大的字母数字c[25]作为"框架"，向框架内不断填充新字母即可
        Arrays.sort(c);
        int i = 25;
        // 如果说出现次数最多的字母有多个，那就把这些字母全部作为框架，回退index至倒数第二多的字母，再进行填充
        while(i >= 0 && c[i] == c[25]) i--;

        // 该公式含义为
        // c[25]-1 是框架内的空缺数，这些空缺用来填充其他字母
        // n + 1 空缺里又至少需要这么多的空位才能保证process之间有效冷却
        // 25 - i 上面计算有一些重叠的部分，重叠的就是框架字母本身，所以去掉重叠
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
