package lc621;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space
 *
 * 关于公式的真正解释 https://www.cnblogs.com/grandyang/p/7098764.html
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
        // 举例来说，ACCCEEE 2，这时候我们得到的答案其实是CEACEXCE
        // 仔细观察可以发现，它的组成其实是，CEA + CEX + CE，有一个重复的pattern段，最后再加上top frequency的词作为框架的结尾
        // 重复段的长度，正好就是n+1，重复段的次数正好是top frequency - 1（毕竟最后我们还要补上框架），最后再补上框架。当然框架可能有多个字母，所以是25-i
        // 对应上面就是，重复段是CEA，长度 n+1 = 3，重复次数c[25]-1 = 2，框架本身CE长度为2，那么 2 * 3 + 2 = 8 -> CEACEXCE
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
