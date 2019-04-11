package lc227;

import java.util.Stack;

/**
 * 用一个栈维护所有的数字和它的符号。。遇到优先级更高的数字就先把栈顶元素计算过再塞回去即可
 * 最后把所有栈内元素加起来就行了
 */
public class Solution227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) number = number * 10 + c - '0';
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') stack.push(number);
                else if (sign == '-') stack.push(-number);
                else if (sign == '*') stack.push(stack.pop() * number);
                else if (sign == '/') stack.push(stack.pop() / number);
                sign = c;
                number = 0;
            }
        }
        int ret = 0;
        for (int num : stack) ret += num;
        return ret;
    }
}
