package lc166;

import java.util.HashMap;
import java.util.Map;

/**
 * 考验大数除法的运算，主要就是如何得出无限循环小数的循环部分
 * 要记住这样的运算技巧
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder fraction = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if (numerator < 0 ^ denominator < 0) fraction.append("-");

        Long dividend = Math.abs(Long.valueOf(numerator));
        Long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) return fraction.toString();
        fraction.append(".");
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // 在第一次这个相同remainder出现的地方之前插入（，随后在后面插入）
                // 所以我们map里面存的都是到这个remainder的长度，到时候找到合适的位置直接插入
                // 合适的位置就是再次找到这个remainder的时刻，我们在第一次遇到它的位置（也就是当时的string长）
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10; // 先把remainder乘10，毕竟原来只是个除剩下的
            fraction.append(remainder / divisor); // 通过divide by divisor，我们得到了相对于divisor剩的最后一位
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
