package lc405;

public class Solution405 {
    public String toHex(int num) {
        char[] hexMap = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.insert(0, hexMap[num & 15]);
            // >>> 避免负数移位
            num >>>= 4;
        }
        return result.toString();
    }
}
