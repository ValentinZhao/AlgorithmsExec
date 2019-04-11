package lc224;

import java.util.Stack;

/**
 * 高赞solution非常巧妙，从头向后遍历这个字符串，一共有五种情况
 * 记住要全局记录一个当前的正负值，它用来帮助计算后面的数字与当前暂存的结果的和或差
 * 这个sign值每次遇到+或-才变号，因为你已经有了前面的结果，你需要读完符号之后的数字才能计算
 * 1. 数字，连续的数字注意要用10*num直到计算到计算符号
 * 2. +，前面数字读完了，我们把前面读到的数字加到暂存结果中
 * 3. -，同上，前面结果读完了，我们把前面读到的数字从暂存结果中减去
 * 4. (，这时候，先推入暂存结果，它表示括号之前的计算结果，再推入sign，它表示括号之前的符号是啥，重置暂存结果和符号
 * 因为现在我们要从新的括号内重新开始读了
 * 5. )，这时候括号读完了，推出符号和结果加在一起！
 *
 * 就是要注意的是每次遇到）就推出上面的两个，就相当于结束一层括号，无论是不是nested的
 */
public class Solution224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0; // 暂存结果
        int number = 0; // 用于计算连续数值间的计算结果
        int sign = 1; // 1是正数，0是负数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number; // 计算括号内结果
                number = 0; // 重置结果不要影响到后面
                result *= stack.pop(); // 拿到括号前的符号，染上符号正负
                result += stack.pop(); // 加上括号前的结果
            }
        }
        if (number != 0) result += sign * number; // 最后在括号后面还有几个跟着的单独的数字比如(....) + 2这样，要加上
        return result;
    }
}
