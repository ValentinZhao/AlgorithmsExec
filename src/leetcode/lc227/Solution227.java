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
                // 有一点非常重要的就是，当c遍历到运算符的时候，sign是比c慢一个运算符的，这样其实是保证sign和c之间的那个数字可以被构建完
                // 这样的话就可以正常进行二则运算了
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
