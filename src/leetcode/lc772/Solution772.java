package lc772;

import java.util.Stack;

/**
 * 本题就是结合起了四则运算还有括号，是计算器的完整版，那么我们就用一种比较generic的方式写出来
 * 这个算法其实是完美兼容lc224（Basic Calculator II）的。
 * 由lc227（Basic Calculator）我们知道没有括号的时候，我们直接把一串数字连同运算符一起入栈，precedence较高的运算符就把当前值和栈顶值运算一下再压入栈
 * 这里有个小不同就是所有元素都入栈，然后出栈的时候按照一个运算符+两个数字这样来弹出就行
 * 这里是一样的道理，只不过有括号的话，我们需要把括号也入栈，这时就方便我们计算括号内的值
 */
public class Solution772 {
    public int calculate(String s) {
        if (s == null) return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                nums.push(num);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                int num = 0;
                while (ops.peek() != '(') {
                    nums.push(doCalcualate(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && isPrecedent(c, ops.peek())) {
                    nums.push(doCalcualate(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }
        if (!ops.isEmpty()) {
            nums.push(doCalcualate(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop(); // 最后栈内一定只剩最后计算剩下的元素，就是答案啦
    }

    /**
     * 如果后面比前面的优先级低，返回false，反之亦然；又由于ops栈里面还有parenthesis，我们遇到这个的时候也要返回false
     */
    private boolean isPrecedent(char c, char op) {
        if (c == '(' || op == ')') return false;
        if ((c == '*' || c == '/') && (op == '+' || op == '-')) return false;
        return true;
    }

    private Integer doCalcualate(char op, Integer a, Integer b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}
