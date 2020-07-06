package jianzhi;

public class Jz53 {
    public boolean isNumeric(char[] str) {
        String s=String.valueOf(str);
        // 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
        /*
        以下对正则进行解释:
        [\\+\\-]?            -> 正或负符号出现与否
        \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
        (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                                否则一起不出现
        ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                                紧接着必须跟着整数；或者整个部分都不出现
        */
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
