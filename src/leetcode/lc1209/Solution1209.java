package lc1209;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1209 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        // 注意这里一定是sb.length，因为StringBuilder的长度其实一直在变的，否则直接用原字符串长度会数组越界
        // 毕竟后面StringBuilder逐渐变短了取不到后面的index
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                stack.push(1);
            } else {
                int count = stack.pop() + 1;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(count);
                }
            }
        }
        return sb.toString();
    }
}
