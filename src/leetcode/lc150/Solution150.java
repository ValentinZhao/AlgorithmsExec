package lc150;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        stack.push(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int operands1 = Integer.parseInt(stack.pop());
                int operands2 = Integer.parseInt(stack.pop());
                int result = calculate(operands1, operands2, tokens[i]);
                stack.push(String.valueOf(result));
            } else stack.push(tokens[i]);
        }
        return Integer.parseInt(stack.pop());
    }

    private int calculate(int operands1, int operands2, String operator) {
        int num = (int) operator.charAt(0);
        switch (num) {
            case 42: return operands2 * operands1;
            case 43: return operands2 + operands1;
            case 45: return operands2 - operands1;
            case 47: return operands2 / operands1;
            default: return 0;
        }
    }

    private boolean isOperator(String token) {
        return  token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }
}
