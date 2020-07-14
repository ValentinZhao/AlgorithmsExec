package bytedance.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution394 {
    public String decodeString(String s) {
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();

        StringBuilder currStr = new StringBuilder();
        int currCount = 0;
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currCount = 10 * currCount + ch - '0';
            } else if (ch == '[') { // 进去新一层，把原来的数据先在栈中暂存
                strStack.push(currStr);
                countStack.push(currCount);

                currCount = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tmp = currStr;
                currStr = strStack.pop();
                for (int i = countStack.pop(); i > 0; i--) currStr.append(tmp);
            } else currStr.append(ch);
        }

        return currStr.toString();
    }
}
